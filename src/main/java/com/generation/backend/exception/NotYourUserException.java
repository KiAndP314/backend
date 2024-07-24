package com.generation.backend.exception;

public class NotYourUserException extends RuntimeException{
    public NotYourUserException(String message) {
        super(message);
    }
}
