package com.skanda.InquireUserList.controller;

import com.skanda.InquireUserList.entity.InquireUserListResponse;
import com.skanda.InquireUserList.service.InquireUserListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class InquireUserListController {

    @Autowired
    public InquireUserListServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<InquireUserListResponse>> fetchUserListLogin(@RequestParam String status) {
            return new ResponseEntity<>(userService.inquireUserList(status), HttpStatus.OK);
    }
}
