package com.iapl.userservice.exceptions;

public class ForbiddenRequestException extends RuntimeException{
    public ForbiddenRequestException(String message){
        super(message);
    }
}
