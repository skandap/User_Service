package com.skanda.registerUser.controller;


import com.skanda.registerUser.entity.UserRequest;
import com.skanda.registerUser.entity.UserResponse;
import com.skanda.registerUser.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    public UserServiceImpl userService;


    @PostMapping("/register-user")
    public ResponseEntity<UserResponse> createUserData(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

}
