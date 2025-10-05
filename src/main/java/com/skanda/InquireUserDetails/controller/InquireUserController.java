package com.skanda.InquireUserDetails.controller;

import com.skanda.InquireUserDetails.entity.InquireUserResponse;
import com.skanda.InquireUserDetails.service.InquireUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class InquireUserController {

    @Autowired
    public InquireUserServiceImpl userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<InquireUserResponse> fetchUserLogin(@PathVariable Long userId) {
            return new ResponseEntity<>(userService.inquireUserDetailsById(userId), HttpStatus.OK);
    }
}
