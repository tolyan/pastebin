/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.test;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.unit.TestContext;
import org.junit.After;
import org.junit.Before;

public class IntegrationTest {
    Vertx vertx;
    HttpServer server;

    @Before
    public void before(TestContext context) {
        vertx = Vertx.vertx();
        vertx.exceptionHandler(context.exceptionHandler());
        server = vertx.createHttpServer().requestHandler(req -> req.response().end("/entries")).
                        listen(8080, context.asyncAssertSuccess());
    }

    @After
    public void after(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }
}
