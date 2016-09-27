/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import com.datastax.driver.core.*;
import java.util.*;

public class EntryRepository {
    public static final int DEFAULT_PAGE_SIZE = 5;
    public static final String INSERT_PUBLIC = "INSERT into public_entries" +
            "(entry_uuid, created_at, modified_at, title, body, expires_at, secret, is_private, dummy) " +
            "VALUES (:id, :createdAt, :modifiedAt, :title, :body, :expiresAt, :secret, :isPrivate, 1)";
    public static final String INSERT_PRIVATE = "INSERT into private_entries" +
            "(entry_uuid, created_at, modified_at, title, body, expires_at, secret, is_private) " +
            "VALUES (:id, :createdAt, :modifiedAt, :title, :body, :expiresAt, :secret, :isPrivate);";

    private final Session session;
    private final int pageSize;

    public EntryRepository(Session session, int pageSize){
        this.pageSize = pageSize;
        this.session = session;
    }

    public EntryRepository(Session session){
        pageSize = DEFAULT_PAGE_SIZE;
        this.session = session;
    }

    public Optional<Entry> getEntry(UUID entryId){
        PreparedStatement publicSt = session.prepare("SELECT * FROM public_entries WHERE entry_uuid=?;");
        BoundStatement bound = publicSt.bind(entryId);
        ResultSet publicRS = session.execute(bound);

        PreparedStatement privateSt = session.prepare("SELECT * FROM private_entries WHERE entry_uuid=?;");
        bound = privateSt.bind(entryId);
        ResultSet privateRS = session.execute(bound);

//      dealing with cassandra's eventual consistency  and our data duplication
//      by getting latest modified row  from both column families

        Optional<Entry> maybePublic = renderEntry(publicRS.one());
        Optional<Entry> maybePrivate = renderEntry(privateRS.one());
        Optional<Entry> result = Optional.empty();
        if (maybePrivate.isPresent() && maybePublic.isPresent()){
            int compare = maybePrivate.get().getModifiedAt().compareTo(maybePublic.get().getModifiedAt());
            result = compare > 0 ? maybePrivate : maybePublic;
        } else if (maybePrivate.isPresent()){
            result = maybePrivate;
        } else if (maybePublic.isPresent()){
            result = maybePublic;
        }

        return result;

    }

    /**
     * Saves new instance of {@link Entry} to storage.
     *
     * @param entry
     */
    public void save(Entry entry){
        PreparedStatement st = prepareInsert(entry);
        BoundStatement bound = getBoundStatement(entry, st);
        session.execute(bound);
    }

    private PreparedStatement prepareInsert(Entry entry) {
        PreparedStatement st;
        if(entry.isPrivate()){
            st = session.prepare(INSERT_PRIVATE);
        } else {
            st = session.prepare(INSERT_PUBLIC);
        }
        return st;
    }


    /**
     * Modifies fields of {@link Entry} instance in storage.
     * @param entry
     */

    public void update(Entry entry){
        PreparedStatement st = prepareUpdate(entry);
        BoundStatement bound = getBoundStatement(entry, st);
        session.execute(bound);
    }

    public void delete(Entry entry){
        PreparedStatement st = session.prepare(
                "BEGIN BATCH " +
                        "DELETE FROM private_entries WHERE entry_uuid = :id;" +
                        "DELETE FROM public_entries WHERE entry_uuid = :id;" +
                "APPLY BATCH;"
        );

        BoundStatement bound = st.bind().setUUID("id", entry.getUuid());
        session.execute(bound);
    }

    /**
     * Retrieves all entries from storage in descending order by creation date with pagination.
     * Default page size is 5 entries. Page size can be set in {@link EntryRepository} constructor.
     *
     * @param requestedPage
     * @return
     */

    public EntriesPage getAllEntries(Optional<String> requestedPage){
        Statement st = new SimpleStatement("SELECT * FROM latest_entries");
        st.setFetchSize(pageSize);

        if(requestedPage.isPresent()){
            st.setPagingState(PagingState.fromString(requestedPage.get()));
        }

        ResultSet rs = session.execute(st);
        PagingState nextPage = rs.getExecutionInfo().getPagingState();

        List<Optional<Entry>> entryList = new ArrayList<>();
        int remaining = rs.getAvailableWithoutFetching();
        while(remaining > 0){
            entryList.add(renderEntry(rs.one()));
            remaining--;
        }

        Optional<String> nextPageMaybe;
        if(nextPage == null) {
            nextPageMaybe = Optional.empty();
        } else {
            nextPageMaybe = Optional.ofNullable(nextPage.toString());
        }
        return new EntriesPage(nextPageMaybe, entryList);
    }

    /**
     * Upsert into corresponding cf and delete from public cf if upserting into private one.
     Actual delete will happen only if {@link Entry#isPrivate} field have been changed.
     We dont need to delete from private cf since we resolve eventual consistency during read
     by row modification timestamp . Thus, we reduce amount of compaction work to be done.
     *
     */
    private PreparedStatement prepareUpdate(Entry entry) {
        PreparedStatement st;
        if(entry.isPrivate()){
            st = session.prepare(
                    "BEGIN BATCH " +
                        INSERT_PRIVATE +
                        "DELETE FROM public_entries WHERE entry_uuid=:id;" +
                    "APPLY BATCH;");
        } else {
            st = session.prepare(INSERT_PUBLIC);
        }
        return st;
    }

    private BoundStatement getBoundStatement(Entry entry, PreparedStatement st) {
        return st.bind()
                .setUUID("id", entry.getUuid())
                .setTimestamp("createdAt", entry.getCreatedAt())
                .setTimestamp("modifiedAt", new Date())
                .setString("title", entry.getTitle())
                .setString("body", entry.getBody())
                .setTimestamp("expiresAt", entry.getExpires())
                .setString("secret", entry.getSecret())
                .setBool("isPrivate", entry.isPrivate());
    }

    private Optional<Entry> renderEntry(Row row) {
        if(row != null){
            return Optional.of(new Entry(row.get("entry_uuid", UUID.class),
                    row.get("created_at", Date.class),
                    row.get("modified_at", Date.class),
                    row.get("title", String.class),
                    row.get("body", String.class),
                    row.get("expires_at", Date.class),
                    row.get("secret", String.class),
                    row.get("is_private", Boolean.class)));
        } else {
            return Optional.empty();
        }

    }

}
