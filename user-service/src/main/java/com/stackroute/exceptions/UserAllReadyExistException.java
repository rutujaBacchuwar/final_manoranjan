package com.stackroute.exceptions;

public class UserAllReadyExistException extends Exception {
    private String message;

    public UserAllReadyExistException() {
    }

    //user already exists exception handler method
    public UserAllReadyExistException(String message) {
        super(message);
        this.message = message;

    }
}
