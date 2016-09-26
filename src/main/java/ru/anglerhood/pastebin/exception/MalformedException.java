/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.exception;

public class MalformedException extends RuntimeException{
    public MalformedException(){}
    public MalformedException(String message){
        super(message);
    }
}
