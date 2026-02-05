package com.yann.review_app_backend.exception;

public class SentimentNotFoundException extends RuntimeException {

    public SentimentNotFoundException(Long id) {
        super("Could not find sentiment with id: " + id);
    }

    public SentimentNotFoundException(String message) {
        super(message);
    }

}
