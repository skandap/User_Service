package com.skanda.registerUser.behavior;

public class DuplicateEmailCheck extends RuntimeException {
    public DuplicateEmailCheck(String s) {
        super(s);
    }
}
