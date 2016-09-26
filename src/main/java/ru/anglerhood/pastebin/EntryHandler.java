/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import io.vertx.ext.web.RoutingContext;
import ru.anglerhood.pastebin.exception.ValidationException;

import java.security.SecureRandom;
import java.util.Base64;

public class EntryHandler {
    private final EntryValidator validator;
    private final EntryRepository repository;

    public EntryHandler(EntryValidator validator, EntryRepository repository){
        this.validator = validator;
        this.repository = repository;
    }

    public void createEntry(RoutingContext context){

    }

    public void updateEntry(RoutingContext context){

    }

    public void deleteEntry(RoutingContext context){

    }

    public void listEntries(RoutingContext context) {
    }


    private String convertTitle(String title) {
        if (title == null) {
            return "";
        } else {
            return title;
        }
    }

    private String convertBody(String body) {
        if (body == null) {
            return "";
        } else {
            return body;
        }
    }

    private String generateSecret() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[48];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private Boolean convertIsPrivate(String rawIsPrivate) {
        if (rawIsPrivate == null) {
            return false;
        } else {
            return Boolean.valueOf(rawIsPrivate);
        }
    }

    private long convertTimestamp(String rawTimestamp) throws ValidationException {
        Long result;
        if (rawTimestamp == null) {
            result =  0L;
        } else {
            try {
                result = new Long(rawTimestamp);
            } catch (NumberFormatException ex) {
//                logger.warn("Got invalid EXPIRES value: " + rawTimestamp);
                throw new ValidationException(ex.getMessage());
            }
        }
        return result;
    }


}
