package com.backend.libros.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
