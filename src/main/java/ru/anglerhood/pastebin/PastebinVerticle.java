/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */


package ru.anglerhood.pastebin;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class PastebinVerticle extends AbstractVerticle{

    public static final int PORT = 8080;

    private Cluster cluster;

    public static void main(String[] args) {
  }

    @Override
    public void start() {

        EntryRepository repository = new EntryRepository(getSession());
        EntryValidator validator = new EntryValidator();
        EntryHandler handler = new EntryHandler(validator, repository);

        Router router = Router.router(vertx);
//        router.route("/latest").handler();

        router.post("/entries").handler(handler::createEntry);
        router.put("/entries/:entry-id").handler(handler::updateEntry);
        router.get("/entries").handler(handler::listEntries);
        router.delete("/entries/:entry-id").handler(handler::deleteEntry);


        vertx.createHttpServer().requestHandler(router::accept).listen(PORT);
    }

    private Session getSession() {
        cluster = Cluster.builder()
                .addContactPoint("localhost")
                .build();
        return cluster.connect("pastebin");
    }

}
