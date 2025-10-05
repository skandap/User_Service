package com.skanda.loginUser.controller;


import com.skanda.loginUser.entity.LoginUserRequest;
import com.skanda.loginUser.entity.LoginUserResponse;
import com.skanda.loginUser.service.LoginUserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    public LoginUserServiceImpl userService;


    @PostMapping("/login-user")
    public ResponseEntity<LoginUserResponse> createUserData(@Valid @RequestBody LoginUserRequest userRequest) {
        return new ResponseEntity<>(userService.loginUser(userRequest), HttpStatus.CREATED);
    }
}
