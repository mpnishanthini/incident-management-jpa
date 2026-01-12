package com.example.incident_management_jpa.exception;

public class ResourceNotFoundException extends RuntimeException {

   // private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
