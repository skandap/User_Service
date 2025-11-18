package com.skanda.registerUser.Mappers;


import com.skanda.registerUser.entity.UserRequest;
import com.skanda.registerUser.entity.UserResponse;
import com.skanda.util.entity.Enums.Role;
import com.skanda.util.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {
    public UserEntity userRequestToEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .age(userRequest.getAge())
                .password(userRequest.getPassword())
                .role(userRequest.getRole() != null ? userRequest.getRole() : Role.USER)
                .build();
    }

    public UserResponse userEntityToResponse(UserEntity user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .message("User registered successfully")
                .build();
    }
}
