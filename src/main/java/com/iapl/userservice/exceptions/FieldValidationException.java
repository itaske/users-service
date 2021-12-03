package com.iapl.userservice.exceptions;


public class FieldValidationException extends RuntimeException {
    public FieldValidationException(String message){
        super(message);
    }
}