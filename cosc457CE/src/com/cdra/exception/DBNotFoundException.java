package com.cdra.exception;

public class DBNotFoundException extends RuntimeException {
    public DBNotFoundException(String message){
        super(message);
    }
}
