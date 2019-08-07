package com.stackroute.exception;

public class LanguageNotFoundException extends Exception {
    private String message1;

    public LanguageNotFoundException() {
    }

    //language not found exception handling method
    public LanguageNotFoundException(String message) {
        super(message);
        this.message1 = message;
    }
}
