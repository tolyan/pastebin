/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.test;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.anglerhood.pastebin.PastebinVerticle;

@RunWith(VertxUnitRunner.class)
public class IntegrationTest {
    public static final int PORT = 8080;
    public static final String HOST = "localhost";
    Vertx vertx;
    PastebinVerticle server;

    @Before
    public void before(TestContext context) {
        vertx = Vertx.vertx();
        vertx.exceptionHandler(context.exceptionHandler());
        vertx.deployVerticle(PastebinVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void after(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void createEntry(TestContext context) {
        HttpClient client = vertx.createHttpClient();
        Async async = context.async();
        client.post(PORT, HOST, "/entries", resp -> {
            context.assertEquals(200, resp.statusCode());
            client.close();
            async.complete();
        }).end();

    }
}
