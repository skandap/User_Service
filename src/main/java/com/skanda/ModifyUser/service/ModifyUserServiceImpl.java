package com.skanda.ModifyUser.service;

import com.skanda.ModifyUser.Mappers.ModifyUserMapping;
import com.skanda.ModifyUser.entity.ModifyUserRequest;
import com.skanda.ModifyUser.entity.ModifyUserResponse;
import com.skanda.userProfile.behaviour.UserNotFoundException;
import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyUserServiceImpl implements ModifyUserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ModifyUserMapping userMapping;

    @Override
    public ModifyUserResponse modifyDetailsById(Long userId, ModifyUserRequest modifyUserRequest) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("No user found"));
        UserEntity updatedUser = userMapping.mapToUser(user, modifyUserRequest);
        userRepository.save(updatedUser);
        return ModifyUserResponse.builder().message("User of id " + userId + " updated successfully").build();
    }
}
