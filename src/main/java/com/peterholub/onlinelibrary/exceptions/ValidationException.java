package com.peterholub.onlinelibrary.exceptions;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationException extends Exception {

    private final List<ObjectError> errors;

    public ValidationException(String message, List<ObjectError> errors) {
        super(message);
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return this.errors;
    }
}
