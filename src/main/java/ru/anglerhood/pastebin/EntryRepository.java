/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import com.datastax.driver.core.*;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;


import java.util.*;

public class EntryRepository {
    public static final int DEFAULT_PAGE_SIZE = 5;
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
        PreparedStatement st = session.prepare("SELECT * FROM pastebin_entries WHERE entry_uuid=?");
        BoundStatement bound = st.bind(entryId);
        ResultSet rs = session.execute(bound);
        return renderEntry(rs.one());

    }

    public void save(Entry entry){
        PreparedStatement st = session.prepare(
                "INSERT into pastebin_entries" +
                        "(entry_uuid, created_at, modified_at, title, body, expires_at, secret, is_private) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        BoundStatement bound = st.bind(entry.getUuid(), entry.getCreatedAt(), entry.getModifiedAt(), entry.getTitle(),
                entry.getBody(), entry.getExpires(), entry.getSecret(), entry.isPrivate());
        session.execute(bound);
    }

    public void update(Entry entry){
        this.save(entry);
    }

    public void delete(Entry entry){

    }

    public EntriesPage getAllEntries(String requestedPage){
        Statement st = new SimpleStatement("SELECT * FROM pastebin_entries");
        st.setFetchSize(pageSize);

        if(requestedPage != null){
            st.setPagingState(PagingState.fromString(requestedPage));
        }

        ResultSet rs = session.execute(st);
        PagingState nextPage = rs.getExecutionInfo().getPagingState();

        List<Optional<Entry>> entryList = new ArrayList<>();
        int remaining = rs.getAvailableWithoutFetching();
        while(remaining > 0){
            entryList.add(renderEntry(rs.one()));
            remaining--;
        }

        return new EntriesPage(Optional.ofNullable(nextPage.toString()), entryList);
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
