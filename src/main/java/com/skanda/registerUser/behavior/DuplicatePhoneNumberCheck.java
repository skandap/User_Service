package com.skanda.registerUser.behavior;

public class DuplicatePhoneNumberCheck extends RuntimeException {
    public DuplicatePhoneNumberCheck(String s) {
        super(s);
    }
}
