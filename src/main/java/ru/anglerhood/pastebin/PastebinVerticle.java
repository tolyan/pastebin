/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */


package ru.anglerhood.pastebin;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class PastebinVerticle extends AbstractVerticle{

    public static final int PORT = 8080;

    private Cluster cluster;

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(PastebinVerticle.class.getName());
  }

    @Override
    public void start() {

        EntryRepository repository = new EntryRepository(getSession());
        EntryValidator validator = new EntryValidator();
        EntryHandler handler = new EntryHandler(validator, repository);

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.route("/api/*").consumes("application/json");
        router.route("/api/*").produces("application/json");
        router.route("/latest").handler(handler::latest);

        router.post("/api/entries")
                .consumes("application/x-www-form-urlencoded")
                .produces("application/json")
                .handler(handler::createEntry);

        router.put("/api/entries/:id/:secret")
                .handler(handler::updateEntry);

        router.get("/api/entries")
                .handler(handler::listEntries);

        router.get("/api/entries/:id")
                .handler(handler::readEntry);

        router.get("/api/entries/:id/:secret")
                .handler(handler::readEntry);

        router.delete("/api/entries/:id/:secret")
                .handler(handler::deleteEntry);



        vertx.createHttpServer().requestHandler(router::accept).listen(PORT);
    }

    private Session getSession() {
        cluster = Cluster.builder()
                .addContactPoint("localhost")
                .build();
        return cluster.connect("pastebin");
    }

}
