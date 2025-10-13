package com.skanda.loginUser.Mappers;

import com.skanda.util.entity.UserEntity;
import com.skanda.loginUser.entity.LoginUserResponse;
import com.skanda.loginUser.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LoginUserMapping {

    public LoginUserResponse userEntityToResponse(UserEntity user, String token) {
        return LoginUserResponse.builder()
                .token(token)
                .user(mapToUser(user))
                .build();
    }

    public User mapToUser(UserEntity userEntity) {
        return User.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhoneNumber())
                .build();
    }
}
