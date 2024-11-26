package com.scalefocus.libraryproject.exceptions;

public class EmailNotExisting extends RuntimeException{

    public EmailNotExisting(String emailDoesNotExist) {
        super(emailDoesNotExist);
    }
}
