package com.skanda.InquireUserDetails.behaviour;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
