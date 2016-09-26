/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.exception;

import java.util.UUID;

public class EntryNotFoundException extends RuntimeException {
    public EntryNotFoundException(){}

    public EntryNotFoundException(UUID entryId){
        super("Entry not found: " + entryId == null ? "null" : entryId.toString());
    }
}
