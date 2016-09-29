/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.DecodeException;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.sockjs.BridgeEventType;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import ru.anglerhood.pastebin.bean.EntriesPage;
import ru.anglerhood.pastebin.bean.Entry;
import ru.anglerhood.pastebin.exception.EntryNotFoundException;
import ru.anglerhood.pastebin.exception.ForbiddenException;
import ru.anglerhood.pastebin.exception.MalformedException;
import ru.anglerhood.pastebin.exception.ValidationException;

import io.vertx.ext.web.handler.sockjs.SockJSHandler;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

public class EntryHandler {
    private final EntryValidator validator;
    private final EntryRepository repository;
    private final Logger logger = LoggerFactory.getLogger(EntryHandler.class);

    public EntryHandler(EntryValidator validator, EntryRepository repository){
        this.validator = validator;
        this.repository = repository;
    }

    public void createEntry(RoutingContext context){
        HttpServerResponse resp  = context.response();
        try{
            Entry reqEntry = Json.decodeValue(context.getBodyAsString(), Entry.class);
            reqEntry.setUuid(UUID.randomUUID());
            reqEntry.setSecret(generateSecret());
            validator.validate(reqEntry);
            repository.save(reqEntry);
            resp.setStatusCode(201);
            String chunk = Json.encodePrettily(reqEntry);
            if(!reqEntry.getPrivate()){
                context.vertx().eventBus().publish("entry.created", chunk);
            }
            resp.headers().add(HttpHeaders.CONTENT_LENGTH, Integer.toString(chunk.length()));
            resp.write(chunk);

        } catch(DecodeException ex){
            logger.warn("Got malformed request: " + context.getBodyAsString());
            resp.setStatusCode(400);
        } catch(ValidationException ex){
            logger.warn("Got unprocessable request: " + context.getBodyAsString());
            resp.setStatusCode(422);
        }

        resp.putHeader("content-type", "application/json; charset=utf-8")
            .end();
    }

    public void readEntry(RoutingContext context){

        HttpServerResponse resp  = context.response();
        Optional<String> maybeId = Optional.ofNullable(context.request().getParam("id"));
        Optional<String> maybeSecret = Optional.ofNullable(context.request().getParam("secret"));

        try{
            Entry result = maybeId.flatMap(id -> repository.getEntry(UUID.fromString(id)))
                    .orElseThrow(EntryNotFoundException::new);
            if(result.getPrivate()){
                if (maybeSecret
                        .map(s -> s.equals(result.getSecret()))
                        .orElseThrow(ForbiddenException::new)){
                    writeResult(resp, result);
                } else {
                    throw new ForbiddenException();
                }
            }
            writeResult(resp, result);
        } catch (IllegalArgumentException | MalformedException ex){
            logger.warn("Malformed READ request: " + context.request().path());
            resp.setStatusCode(400);
        } catch (EntryNotFoundException ex){
            logger.warn("Request READ for unkown entry with id: " + maybeId.get());
            resp.setStatusCode(404);
        } catch (ForbiddenException ex){
            logger.warn("Unauthorized READ request for private entry: " + context.request().path());
            resp.setStatusCode(403);
        }
        resp.putHeader("content-type", "application/json; charset=utf-8")
            .end();
    }



    public void updateEntry(RoutingContext context){
        HttpServerResponse resp  = context.response();
        Optional<String> maybeId = Optional.ofNullable(context.request().getParam("id"));
        Optional<String> maybeSecret = Optional.ofNullable(context.request().getParam("secret"));

        try{
            Entry reqEntry = Json.decodeValue(context.getBodyAsString(), Entry.class);
            validator.validate(reqEntry);
            Entry result = maybeId.flatMap(id -> repository.getEntry(UUID.fromString(id)))
                    .orElseThrow(EntryNotFoundException::new);
            if(maybeSecret
                    .map(s -> s.equals(result.getSecret()))
                    .orElseThrow(ForbiddenException::new)){
                result.setTitle(reqEntry.getTitle());
                result.setBody(reqEntry.getBody());
                result.setExpires(reqEntry.getExpires());
                result.setPrivate(reqEntry.getPrivate());
                repository.update(result);
                resp.setStatusCode(200);
            }

        } catch (IllegalArgumentException | MalformedException ex){
            logger.warn("Malformed UPDATE request: " + context.request().path());
            resp.setStatusCode(400);

        } catch (EntryNotFoundException ex){
            logger.warn("Request UPDATE for unkown entry with id: " + maybeId.get());
            resp.setStatusCode(404);

        } catch (ForbiddenException ex){
            logger.warn("Unauthorized UPDATE request for private entry: " + context.request().path());
            resp.setStatusCode(403);

        } catch(ValidationException ex){
            logger.warn("Unprocessable UPDATE request: " + context.getBodyAsString());
            resp.setStatusCode(422);
        }
        resp.putHeader("content-type", "application/json; charset=utf-8")
            .end();

    }

    public void deleteEntry(RoutingContext context){
        HttpServerResponse resp  = context.response();
        Optional<String> maybeId = Optional.ofNullable(context.request().getParam("id"));
        Optional<String> maybeSecret = Optional.ofNullable(context.request().getParam("secret"));

        try{
            Entry result = maybeId.flatMap(id -> repository.getEntry(UUID.fromString(id)))
                    .orElseThrow(EntryNotFoundException::new);
            if(maybeSecret
                    .map(s -> s.equals(result.getSecret()))
                    .orElseThrow(ForbiddenException::new)){
                repository.delete(result);
                context.response().setStatusCode(204);
            }
        } catch (IllegalArgumentException | MalformedException ex){
            logger.warn("Malformed DELETE request: " + context.request().path());
            resp.setStatusCode(400);
        } catch (EntryNotFoundException ex){
            logger.warn("Request DELETE for unkown entry with id: " + maybeId.get());
            resp.setStatusCode(404);
        } catch (ForbiddenException ex){
            logger.warn("Unauthorized DELETE request for private entry: " + context.request().path());
            resp.setStatusCode(403);
        }
        resp.putHeader("content-type", "application/json; charset=utf-8")
            .end();

    }

    public void listEntries(RoutingContext context) {
        HttpServerResponse resp  = context.response();

        EntriesPage page = repository.getAllEntries(Optional.ofNullable(context.request().params().get("page")));
        JsonArray pageEntries = new JsonArray();
        for(Optional<Entry> entry : page.getEntries()){
            entry.ifPresent(e -> pageEntries.add(Json.encodePrettily(e)));
        }
        JsonObject result = new JsonObject();
        result.put("entries", pageEntries);
        page.getPagingString()
                .ifPresent(ps -> result.put("next", ps));


        resp.setStatusCode(200);
        String chunk = result.toString();
        resp.headers().add(HttpHeaders.CONTENT_LENGTH, Integer.toString(chunk.length()));
        resp.write(chunk);
        resp.putHeader("content-type", "application/json; charset=utf-8")
            .end();

    }


    private void writeResult(HttpServerResponse resp, Entry result) {
        resp.setStatusCode(200);
        String chunk = Json.encodePrettily(result);
        resp.headers().add(HttpHeaders.CONTENT_LENGTH, Integer.toString(chunk.length()));
        resp.write(chunk);
    }

    private String generateSecret() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32).toString();
    }

    public SockJSHandler latest(RoutingContext context) {
        BridgeOptions options = new BridgeOptions();
        return SockJSHandler.create(context.vertx()).bridge(options, event -> {
            if (event.type() == BridgeEventType.SOCKET_CREATED) {
                logger.info("A socket was created");
            }
            event.complete(true);
        });
    }
}
