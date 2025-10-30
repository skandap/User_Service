package com.skanda.InquireUserDetails.controller;

import com.skanda.InquireUserDetails.entity.InquireUserResponse;
import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
public class InternalUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<InquireUserResponse> getUserForInternalUse(@PathVariable Long userId,
                                                                     @RequestHeader("X-INTERNAL-SECRET") String internalSecret) {
        // Verify secret
        if (!"edgeverve-internal-key".equals(internalSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        InquireUserResponse response = new InquireUserResponse();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return ResponseEntity.ok(response);
    }
}
