/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.anglerhood.pastebin.PastebinVerticle;
import ru.anglerhood.pastebin.bean.Entry;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(VertxUnitRunner.class)
public class HttpTest {
    public static final int PORT = 8080;
    public static final String HOST = "localhost";
    Vertx vertx;
    private final Logger logger = LoggerFactory.getLogger(HttpTest.class);

    @Before
    public void before(TestContext context) {
        Cluster cluster = Cluster.builder()
                .addContactPoint("localhost")
                .withPort(9042)
                .build();
        Session session = cluster.connect("pastebin");
        session.execute("TRUNCATE public_entries");
        session.execute("TRUNCATE private_entries");
        vertx = Vertx.vertx();
        vertx.exceptionHandler(context.exceptionHandler());
        vertx.deployVerticle(PastebinVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void after(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void createReadEntry(TestContext context) {
        Entry entry = writeEntry(context);

        Async async2 = context.async();
        HttpClient client2 = vertx.createHttpClient();
        logger.info("Second client start");
        HttpClientRequest reqGet =  client2.get(PORT, HOST, "/entries/"+context.get("id"), getResp ->{
            context.assertEquals(200, getResp.statusCode());
            getResp.bodyHandler(respBody -> {
                Entry getEntry = Json.decodeValue(respBody.toString(), Entry.class);
                context.assertEquals(getEntry.getBody(), entry.getBody());
                context.assertEquals(getEntry.getTitle(), entry.getTitle());
                context.assertEquals(getEntry.getPrivate(), entry.getPrivate());
                context.assertEquals(getEntry.getExpires(), entry.getExpires());
            });
            client2.close();
            async2.complete();
        });

        reqGet.headers().add(HttpHeaders.CONTENT_TYPE,"application/json; charset=utf-8");
        reqGet.end();
    }



    @Test
    public void writeDelete(TestContext context){
        Entry entry = writeEntry(context);

        Async async2 = context.async();
        HttpClient client2 = vertx.createHttpClient();
        logger.info("Second client start");
        HttpClientRequest reqGet =  client2.delete(PORT, HOST, "/entries/" +
                                                                context.get("id") + "/" +
                                                                context.get("secret"), delResp ->{
            context.assertEquals(204, delResp.statusCode());
            client2.close();
            async2.complete();
        });

        reqGet.headers().add(HttpHeaders.CONTENT_TYPE,"application/json; charset=utf-8");
        reqGet.end();

    }


    @Test
    public void getPagedEntries(TestContext context){
        Entry entry = new Entry();
        entry.setBody("body");
        entry.setTitle("title");
        entry.setPrivate(false);
        String body = Json.encode(entry);

        HttpClient client = vertx.createHttpClient();
        int entriesAmount = 6;
        Async async = context.async(entriesAmount);

        IntStream.range(0, entriesAmount).forEach(i -> {
            HttpClientRequest req = client.post(PORT, HOST, "/entries", resp -> {
                context.assertEquals(201, resp.statusCode());
                resp.bodyHandler(postBody -> {
                    Entry returnEntry = Json.decodeValue(postBody.toString(), Entry.class);
                    context.assertTrue(returnEntry.getSecret().length() > 0);
                    context.assertEquals(entry.getBody(), returnEntry.getBody());
                    async.countDown();
                });
            });

            req.headers().add(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded; charset=utf-8");
            req.headers().add(HttpHeaders.CONTENT_LENGTH, Integer.toString(body.length()));
            req.write(body);
            req.exceptionHandler(context::fail);
            req.end();
        });

        async.awaitSuccess();
        client.close();

        HttpClient client2 = vertx.createHttpClient();
        Async async2 = context.async();
        HttpClientRequest reqGet = client2.get(PORT, HOST, "/entries", resp -> {
            context.assertEquals(200, resp.statusCode());
            resp.bodyHandler(getBody -> {
                HashMap map = Json.decodeValue(getBody.toString(), HashMap.class);
                String nextPage = (String)map.get("next");
                context.put("page", nextPage);
                ArrayList entries = (ArrayList)map.get("entries");
                context.assertEquals(5, entries.size());
                client2.close();
                async2.complete();
            });

        });

        reqGet.headers().add(HttpHeaders.CONTENT_TYPE,"application/json; charset=utf-8");
        reqGet.end();

        async2.awaitSuccess();

        HttpClient client3 = vertx.createHttpClient();
        Async async3 = context.async();
        HttpClientRequest nextReqGet = client3.get(PORT, HOST, "/entries?page=" + context.get("page"), resp -> {
            context.assertEquals(200, resp.statusCode());
            resp.bodyHandler(getBody -> {
                HashMap map = Json.decodeValue(getBody.toString(), HashMap.class);
                String nextPage = (String)map.get("next");
                ArrayList entries = (ArrayList)map.get("entries");
                context.assertEquals(entries.size(), 1);
                client3.close();
                async3.complete();
            });

        });

        nextReqGet.headers().add(HttpHeaders.CONTENT_TYPE,"application/json; charset=utf-8");
        nextReqGet.end();

    }

    private Entry writeEntry(TestContext context) {
        Entry entry = new Entry();
        entry.setBody("body");
        entry.setTitle("title");
        entry.setPrivate(false);
        String body = Json.encode(entry);

        HttpClient client = vertx.createHttpClient();
        Async async = context.async(2);
        HttpClientRequest req = client.post(PORT, HOST, "/entries", resp -> {
            context.assertEquals(201, resp.statusCode());
            resp.bodyHandler(postBody -> {
                Entry returnEntry = Json.decodeValue(postBody.toString(), Entry.class);
                context.assertTrue(returnEntry.getSecret().length() > 0);
                context.assertEquals(entry.getBody(), returnEntry.getBody());
                context.put("id", returnEntry.getUuid().toString());
                context.put("secret", returnEntry.getSecret());
                async.complete();
            });
            client.close();
        });


        req.headers().add(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded; charset=utf-8");
        req.headers().add(HttpHeaders.CONTENT_LENGTH, Integer.toString(body.length()));
        req.write(body);
        req.exceptionHandler(context::fail);
        req.end();

        async.awaitSuccess();
        return entry;
    }

}
