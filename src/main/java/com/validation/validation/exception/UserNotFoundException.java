package com.validation.validation.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("Could Not find a User");
    }
    public UserNotFoundException(String message){
        super(message);
    }
}
