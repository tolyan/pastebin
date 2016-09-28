/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.exception;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(){}
    public ForbiddenException(String message){
        super(message);
    }
}
