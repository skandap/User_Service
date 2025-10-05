package com.skanda.ModifyUser.Mappers;

import com.skanda.ModifyUser.entity.ModifyUserRequest;
import com.skanda.util.entity.Status;
import com.skanda.util.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class ModifyUserMapping {

    public UserEntity mapToUser(UserEntity userEntity, ModifyUserRequest modifyUserRequest) {
        return UserEntity.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .email( userEntity.getEmail())
                .phoneNumber( userEntity.getPhoneNumber())
                .age(userEntity.getAge())
                .password(userEntity.getPassword())
                .createdAt(userEntity.getCreatedAt())
                .status(Status.valueOf(modifyUserRequest.getStatus().toUpperCase()))
                .build();
    }

}
