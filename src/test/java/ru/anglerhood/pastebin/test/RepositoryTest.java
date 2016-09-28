/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */

package ru.anglerhood.pastebin.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import io.vertx.core.logging.LoggerFactory;
import org.junit.*;

import ru.anglerhood.pastebin.bean.EntriesPage;
import ru.anglerhood.pastebin.bean.Entry;

import ru.anglerhood.pastebin.EntryRepository;
import ru.anglerhood.pastebin.exception.EntryNotFoundException;

import java.util.*;
import io.vertx.core.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;


public class RepositoryTest {
    private EntryRepository underTest;
    private Cluster cluster;
    private Session session;
    private int pageSize = 5;
    private final Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

    @Before
    public void setup() {
        cluster = Cluster.builder()
                .addContactPoint("localhost")
                .withPort(9042)
                .build();
        session = cluster.connect("pastebin");
        underTest = new EntryRepository(session, pageSize);
        session.execute("TRUNCATE public_entries");
        session.execute("TRUNCATE private_entries");
    }

    @After
    public void clear() {
        session.execute("TRUNCATE public_entries");
        session.execute("TRUNCATE private_entries");
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
        assertEquals(privateMark, result.getPrivate());
    }

    @Test
    public void writeUpdateReadTest(){
        Date oldDate = new Date();
        UUID oldUUID = UUID.randomUUID();
        String oldTitle = "Old Title";
        String oldBody = "Old Body";
        String oldSecret = "Old secret";
        Boolean oldMark = true;

        Entry entry = new Entry(oldUUID, oldDate, oldDate, oldTitle, oldBody, oldDate, oldSecret, oldMark);
        underTest.save(entry);

        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        String title = "Title";
        String body = "Body";
        String secret = "secret";
        Boolean mark = false;

        entry.setTitle(title);
        entry.setBody(body);
        entry.setExpires(date);
        entry.setSecret(secret);
        entry.setPrivate(mark);

        underTest.update(entry);
        Entry result  = underTest.getEntry(oldUUID).
                orElseThrow(() -> new EntryNotFoundException(oldUUID));
        assertEquals(entry.getUuid(), result.getUuid());
        assertEquals(entry.getTitle(), result.getTitle());
        assertEquals(entry.getBody(), result.getBody());
        assertEquals(entry.getPrivate(), result.getPrivate());
        assertEquals(entry.getSecret(), result.getSecret());
    }

    @Test
    public void write21GetAllPagesTest(){
        String title = "Title";
        String body = "Body";
        String secret = "secret";

        int entriesAmount = 21;
        Stream<Entry> entries = IntStream.range(1, entriesAmount+1)
                .mapToObj(i -> new Entry(UUID.randomUUID(), new Date(), new Date(), title + i,
                        body, null, secret + i, false));
        entries.forEach(entry -> underTest.save(entry));


        EntriesPage page = underTest.getAllEntries(Optional.empty());
        page.getPagingString();
        List<Optional<Entry>>  resultEntriesPage = page.getEntries();

        int count = resultEntriesPage.size();
        assertEquals(count, pageSize);

        while(page.getPagingString().isPresent()){
            page = underTest.getAllEntries(page.getPagingString());
            resultEntriesPage.addAll(page.getEntries());
        }


        assertEquals(entriesAmount,resultEntriesPage.size());
        List<Optional<Entry>>  beforeSort = new ArrayList<>(resultEntriesPage);
        resultEntriesPage.sort((maybeE2, maybeE1) -> maybeE1.get().getCreatedAt()
                                                    .compareTo(maybeE2.get().getCreatedAt()));

        assertTrue(beforeSort.equals(resultEntriesPage));
    }

    @Test
    public void writeDeleteTest(){
        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        String title = "Title";
        String body = "Body";
        String secret = "secret";
        Boolean privateMark = true;
        Entry abstractEntry = new Entry(uuid, date, date, title, body, date, secret, privateMark);
        underTest.save(abstractEntry);
        underTest.delete(abstractEntry);
        assertFalse(underTest.getEntry(uuid).isPresent());
    }


}
