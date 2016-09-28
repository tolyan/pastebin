/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import ru.anglerhood.pastebin.bean.Entry;
import ru.anglerhood.pastebin.exception.ValidationException;

import java.util.Date;

public class EntryValidator {
    public void validate (Entry abstractEntry) throws ValidationException {
        Date expires = abstractEntry.getExpires();
        if(expires != null){
            if(expires.compareTo(new Date()) < 0)
                throw new ValidationException("Expires date: " + expires + "is in the past.");
        }
    }
}
