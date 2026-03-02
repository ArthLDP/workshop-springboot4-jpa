package com.springbootproject.workshop.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found id: " + id);
    }
}
