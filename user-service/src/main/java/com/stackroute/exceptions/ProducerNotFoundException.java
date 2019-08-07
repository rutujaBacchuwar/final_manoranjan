package com.stackroute.exceptions;

public class ProducerNotFoundException extends Exception {
    private String message;

    public ProducerNotFoundException() {
    }

    //user already exists exception handler method
    public ProducerNotFoundException(String message) {
        super(message);
        this.message = message;

    }
}
