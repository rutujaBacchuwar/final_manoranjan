package com.stackroute.exceptions;

public class ProducerAllReadyExistException extends Exception {
    private String message;

    public ProducerAllReadyExistException() {
    }

    //user already exists exception handler method
    public ProducerAllReadyExistException(String message) {
        super(message);
        this.message = message;

    }
}
