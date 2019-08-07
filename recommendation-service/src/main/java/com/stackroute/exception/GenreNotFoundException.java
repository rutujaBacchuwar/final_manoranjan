package com.stackroute.exception;

public class GenreNotFoundException extends Exception {
    private String message1;

    public GenreNotFoundException() {
    }

    //genre not found exception handler method
    public GenreNotFoundException(String message) {
        super(message);
        this.message1 = message;
    }
}
