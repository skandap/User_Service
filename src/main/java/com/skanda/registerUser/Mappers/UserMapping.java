package com.skanda.registerUser.Mappers;


import com.skanda.registerUser.entity.UserRequest;
import com.skanda.registerUser.entity.UserResponse;
import com.skanda.util.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapping {
    public UserEntity userRequestToEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .age(userRequest.getAge())
                .password(userRequest.getPassword())
                .build();
    }

    public UserResponse userEntityToResponse(UserEntity user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhoneNumber())
                .age(user.getAge())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
