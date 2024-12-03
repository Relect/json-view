package com.example.json_viev.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(long id) {
        super("user not found id:" + id);
    }
}
