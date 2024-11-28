package com.scalefocus.libraryproject.exceptions;

public class RegisterException extends RuntimeException {
    public RegisterException() {
    }
    public RegisterException(String message) {
        super(message);
    }
}
