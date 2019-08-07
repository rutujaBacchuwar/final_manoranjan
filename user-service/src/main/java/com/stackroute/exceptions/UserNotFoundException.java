package com.stackroute.exceptions;

public class UserNotFoundException extends Exception {
    private String message;

    public UserNotFoundException() {
    }

    //user not found exception handler method
    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}