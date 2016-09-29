/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import ru.anglerhood.pastebin.bean.Entry;
import ru.anglerhood.pastebin.exception.ValidationException;

import java.util.Date;

/**
 * Basic validator for entries. Can be developed further for validation rules support.
 */
public class EntryValidator {

    /**
     * Checks if expires date is in the future.
     * @param abstractEntry
     * @throws ValidationException
     */
    public void validate (Entry abstractEntry) throws ValidationException {
        Date expires = abstractEntry.getExpires();
        if(expires != null){
            if(expires.compareTo(new Date()) < 0)
                throw new ValidationException("Expires date: " + expires + "is in the past.");
        }
    }
}
