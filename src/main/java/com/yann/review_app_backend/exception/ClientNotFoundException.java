package com.yann.review_app_backend.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id) {
        super("Could not find client with id: " + id);
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
