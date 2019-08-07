package com.stackroute.exception;

public class MediaNotFoundException extends Exception {
    private String message1;

    public MediaNotFoundException() {
    }

    //media not found exception handler method
    public MediaNotFoundException(String message) {
        super(message);
        this.message1 = message;
    }
}
