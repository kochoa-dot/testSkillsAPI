package com.test.Test.of.skills.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id_user){
        super("Could not found the user with id " + id_user);
    }
}
