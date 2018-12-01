package com.cdra.exception;

public class DBControllerException extends RuntimeException {
    public DBControllerException(String message){
        super(message);
    }
}
