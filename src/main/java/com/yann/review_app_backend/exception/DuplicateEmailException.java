package com.yann.review_app_backend.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("a client with this email already exists : " + email);
    }

    public DuplicateEmailException(String message, Throwable cause) {
        super(message, cause);
    }



}
