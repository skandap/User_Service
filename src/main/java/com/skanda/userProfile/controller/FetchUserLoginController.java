package com.skanda.userProfile.controller;

import com.skanda.userProfile.entity.FetchUserResponse;
import com.skanda.userProfile.service.FetchUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class FetchUserLoginController {

    @Autowired
    public FetchUserServiceImpl userService;

    @GetMapping("/profile")
    public ResponseEntity<FetchUserResponse> fetchUserLogin(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null) {
            return new ResponseEntity<>(userService.fetchDetailsById(authHeader), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
