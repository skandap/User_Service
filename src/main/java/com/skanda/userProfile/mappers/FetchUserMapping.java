package com.skanda.userProfile.mappers;


import com.skanda.util.entity.UserEntity;
import com.skanda.userProfile.entity.FetchUserResponse;
import org.springframework.stereotype.Component;

@Component
public class FetchUserMapping {

    public FetchUserResponse userEntityToResponse(UserEntity user) {
        return FetchUserResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
