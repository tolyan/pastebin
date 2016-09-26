/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */

package ru.anglerhood.pastebin.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.junit.*;

import ru.anglerhood.pastebin.Entry;

import ru.anglerhood.pastebin.EntryRepository;
import ru.anglerhood.pastebin.exception.EntryNotFoundException;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class RepositoryTest {
    private EntryRepository underTest;
    private Cluster cluster;
    private Session session;
    private int pageSize = 5;

    @Before
    public void setup() {
        cluster = Cluster.builder()
                .addContactPoint("localhost")
                .withPort(9042)
                .build();
        session = cluster.connect("pastebin");
        underTest = new EntryRepository(session, pageSize);
        session.execute("TRUNCATE pastebin_entries");
    }

    @After
    public void clear() {
//        session.execute("TRUNCATE pastebin_entries");
        cluster.close();
    }

    @Test(expected = EntryNotFoundException.class)
    public void notFoundTest(){
        UUID random = UUID.randomUUID();
        underTest.getEntry(UUID.randomUUID()).
                orElseThrow(() -> new EntryNotFoundException(random));
    }

    @Test
    public void writeReadTest() {
        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        String title = "Title";
        String body = "Body";
        String secret = "secret";
        Boolean privateMark = true;
        Entry abstractEntry = new Entry(uuid, date, date, title, body, date, secret, privateMark);
        underTest.save(abstractEntry);
        Entry result = underTest.getEntry(uuid).
                orElseThrow(() -> new EntryNotFoundException(uuid));
        assertEquals(abstractEntry, result);
        assertEquals(uuid, result.getUuid());
        assertEquals(date, result.getCreatedAt());
        assertEquals(date, result.getModifiedAt());
        assertEquals(title, result.getTitle());
        assertEquals(body, result.getBody());
        assertEquals(secret, result.getSecret());
       assertEquals(privateMark, result.isPrivate());
    }

    @Test
    public void writeUpdateReadTest(){
        Date oldDate = new Date();
        UUID oldUUID = UUID.randomUUID();
        String oldTitle = "Old Title";
        String oldBody = "Old Body";
        String oldSecret = "Old secret";
        Boolean oldMark = false;

        Entry entry = new Entry(oldUUID, oldDate, oldDate, oldTitle, oldBody, oldDate, oldSecret, oldMark);
        underTest.save(entry);

        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        String title = "Title";
        String body = "Body";
        String secret = "secret";
        Boolean mark = true;

;       entry.setCreatedAt(date);
        entry.setModifiedAt(date);
        entry.setTitle(title);
        entry.setBody(body);
        entry.setExpires(date);
        entry.setSecret(secret);
        entry.setIsPrivate(mark);

        underTest.update(entry);
        Entry result  = underTest.getEntry(oldUUID).
                orElseThrow(() -> new EntryNotFoundException(oldUUID));
        assertEquals(entry.getUuid(), result.getUuid());
        assertEquals(entry.getModifiedAt(), result.getModifiedAt());
        assertEquals(entry.getTitle(), result.getTitle());
        assertEquals(entry.getBody(), result.getBody());
        assertEquals(entry.isPrivate(), result.isPrivate());
        assertEquals(entry.getSecret(), result.getSecret());

        assertEquals(oldDate, result.getCreatedAt());



    }

    @Test
    public void write21GetAllPagesTest(){
//        Date date = new Date();
//        UUID uuid = UUID.randomUUID();
//        String title = "Title";
//        String body = "Body";
//        String secret = "secret";
//        Boolean privateMark = true;
//
//        int entriesAmount = 21;
//        Stream<Entry> entries = IntStream.range(1, entriesAmount+1)
//                .mapToObj(i -> new Entry(UUID.randomUUID(), new Date(), new Date(), title + i,
//                        body, null, secret + i, false));
//        entries.forEach(entry -> underTest.save(entry));
//
//
//        EntriesPage page = underTest.getAllEntries(null);
//        String pagingState = page.getPagingState();
//        List<Entry> resultEntriesPage = page.getEntries();
//
//        int count = resultEntriesPage.size();
//        assertEquals(count, pageSize);
//
//        while(pagingState != null){
//            page = underTest.getAllEntries(pagingState);
//            pagingState =  page.getPagingState();
//            resultEntriesPage.addAll(page.getEntries());
//        }
//
//        assertEquals(entriesAmount,resultEntriesPage.size());
//        List<Entry> beforeSort = new ArrayList<>(resultEntriesPage);
//        resultEntriesPage.sort((Entry e1, Entry e2) -> e2.getCreatedAt().compareTo(e1.getCreatedAt()));
//
//        assertTrue(beforeSort.equals(resultEntriesPage));



    }




}
