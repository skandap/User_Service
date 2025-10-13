package com.skanda.ModifyUser.controller;

import com.skanda.ModifyUser.entity.ModifyUserRequest;
import com.skanda.ModifyUser.entity.ModifyUserResponse;
import com.skanda.ModifyUser.service.ModifyUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ModifyUserLoginController {

    @Autowired
    private ModifyUserServiceImpl userService;

    @PutMapping("/modify/{userId}")
    public ResponseEntity<ModifyUserResponse> modifyUser(
            @PathVariable Long userId,
            @RequestBody ModifyUserRequest modifyUserRequest) {
        return new ResponseEntity<>(userService.modifyDetailsById(userId, modifyUserRequest), HttpStatus.OK);
    }
}

