package com.vinibortoletto.SpringMongoCrud.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}