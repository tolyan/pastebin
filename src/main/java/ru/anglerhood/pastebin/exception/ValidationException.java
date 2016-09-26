/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */

package ru.anglerhood.pastebin.exception;


public class ValidationException extends RuntimeException {
    public ValidationException() {}
    public ValidationException(String message){
        super(message);
    }
}
