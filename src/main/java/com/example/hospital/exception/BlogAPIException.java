package com.example.hospital.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {

    private String message;

    public BlogAPIException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
