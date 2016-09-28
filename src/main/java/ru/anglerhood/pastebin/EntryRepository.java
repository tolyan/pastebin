/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import com.datastax.driver.core.*;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import ru.anglerhood.pastebin.bean.EntriesPage;
import ru.anglerhood.pastebin.bean.Entry;

import java.util.*;

public class EntryRepository {
    private final Logger logger = LoggerFactory.getLogger(EntryRepository.class);
    public static final int DEFAULT_PAGE_SIZE = 5;
    public static final String INSERT_PUBLIC = "INSERT into public_entries" +
            "(entry_uuid, created_at, modified_at, title, body, expires_at, secret, is_private, dummy) " +
            "VALUES (:id, :createdAt, :modifiedAt, :title, :body, :expiresAt, :secret, :isPrivate, 1)";
    public static final String INSERT_PRIVATE = "INSERT into private_entries" +
            "(entry_uuid, created_at, modified_at, title, body, expires_at, secret, is_private) " +
            "VALUES (:id, :createdAt, :modifiedAt, :title, :body, :expiresAt, :secret, :isPrivate);";

    public static final String UPDATE_PUBLIC = "INSERT into public_entries" +
            "(entry_uuid, created_at, modified_at, title, body, expires_at, secret, is_private, dummy) " +
            "VALUES (:id, :createdAt, :modifiedAt, :title, :body, :expiresAt, :secret, :isPrivate, 1)";

    public static final String UPDATE_PRIVATE = "INSERT into private_entries" +
            "(entry_uuid, modified_at, title, body, expires_at, secret, is_private) " +
            "VALUES (:id, :modifiedAt, :title, :body, :expiresAt, :secret, :isPrivate);";

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
        logger.info("REQUEST: GET entry with id " + entryId.toString());
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
        logger.info("REQUEST: INSERT entry with id " + entry.getUuid().toString());
        PreparedStatement st = prepareInsert(entry);
        BoundStatement bound = st.bind()
                .setUUID("id", entry.getUuid())
                .setTimestamp("createdAt", new Date())
                .setTimestamp("modifiedAt", new Date())
                .setString("title", entry.getTitle())
                .setString("body", entry.getBody())
                .setTimestamp("expiresAt", entry.getExpires())
                .setString("secret", entry.getSecret())
                .setBool("isPrivate", entry.getPrivate());
        session.execute(bound);
    }

    private PreparedStatement prepareInsert(Entry entry) {
        PreparedStatement st;
        if(entry.getPrivate()){
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
        logger.info("REQUEST: INSERT entry with id " + entry.getUuid().toString());
        PreparedStatement st = prepareUpdate(entry);
        BoundStatement bound = st.bind()
                .setUUID("id", entry.getUuid())
                .setTimestamp("modifiedAt", new Date())
                .setString("title", entry.getTitle())
                .setString("body", entry.getBody())
                .setTimestamp("expiresAt", entry.getExpires())
                .setString("secret", entry.getSecret())
                .setBool("isPrivate", entry.getPrivate());
        session.execute(bound);
    }

    public void delete(Entry entry){
        logger.info("REQUEST: DELETE entry with id " + entry.getUuid().toString());
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
        logger.info("REQUEST: GET ALL PAGE with id: " + requestedPage.orElse("first"));

        Statement st = new SimpleStatement("SELECT * FROM latest_entries");
        st.setFetchSize(pageSize);

        //TODO: findout how to wrap null value for page and rewrite to proper Java 8.
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
     We dont need to delete from private cf since we anyway resolve eventual consistency during read
     by row modification timestamp . Thus, we reduce amount of compaction work to be done.
     *
     */
    private PreparedStatement prepareUpdate(Entry entry) {
        PreparedStatement st;
        if(entry.getPrivate()){
            st = session.prepare(
                    "BEGIN BATCH " +
                        UPDATE_PRIVATE +
                        "DELETE FROM public_entries WHERE entry_uuid=:id;" +
                    "APPLY BATCH;");
        } else {
            st = session.prepare(UPDATE_PUBLIC);
        }
        return st;
    }

    private BoundStatement getInsertBoundStatement(Entry entry, PreparedStatement st) {
        return st.bind()
                .setUUID("id", entry.getUuid())
                .setTimestamp("createdAt", new Date())
                .setTimestamp("modifiedAt", new Date())
                .setString("title", entry.getTitle())
                .setString("body", entry.getBody())
                .setTimestamp("expiresAt", entry.getExpires())
                .setString("secret", entry.getSecret())
                .setBool("isPrivate", entry.getPrivate());
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
