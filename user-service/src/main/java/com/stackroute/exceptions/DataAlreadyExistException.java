package com.stackroute.exceptions;

public class DataAlreadyExistException extends Exception {
    String message;

    public DataAlreadyExistException() {
    }

    public DataAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
