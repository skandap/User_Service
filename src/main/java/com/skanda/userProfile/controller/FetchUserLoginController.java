package com.skanda.userProfile.controller;

import com.skanda.userProfile.entity.FetchUserResponse;
import com.skanda.userProfile.service.FetchUserServiceImpl;
import com.skanda.util.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class FetchUserLoginController {

    @Autowired
    private FetchUserServiceImpl userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/profile")
    public ResponseEntity<FetchUserResponse> fetchUserLogin(@RequestHeader("Authorization") String token) {
        String jwtToken = token.startsWith("Bearer ") ? token.substring(7) : token;
        Long userId = jwtService.extractUserId(jwtToken);
        FetchUserResponse response = userService.fetchDetailsById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
