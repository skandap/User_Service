package com.skanda.registerUser.service;

import com.skanda.registerUser.Mappers.UserMapping;
import com.skanda.registerUser.behavior.BothEmailPh;
import com.skanda.registerUser.behavior.DuplicateEmailCheck;
import com.skanda.registerUser.behavior.DuplicatePhoneNumberCheck;
import com.skanda.registerUser.entity.UserRequest;
import com.skanda.registerUser.entity.UserResponse;
import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserMapping userMapping;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity user = userMapping.userRequestToEntity(userRequest);
        userDuplicateCheck(userRequest);
        userRepository.save(user);
        return userMapping.userEntityToResponse(user);
    }

    public void userDuplicateCheck(UserRequest userRequest) {
        List<UserEntity> user = userRepository.findAll();

        boolean bothExists = user.stream().anyMatch(u -> Objects.equals(u.getEmail(), userRequest.getEmail())
                && Objects.equals(u.getPhoneNumber(), userRequest.getPhoneNumber()));
        if (bothExists) {
            throw new BothEmailPh("Email and Phone number already exists.");
        }
        boolean emailExists = user.stream()
                .anyMatch(u -> Objects.equals(u.getEmail(), userRequest.getEmail()));
        if (emailExists) {
            throw new DuplicateEmailCheck("Email already exists.");
        }
        boolean phoneExists = user.stream()
                .anyMatch(u -> Objects.equals(u.getPhoneNumber(), userRequest.getPhoneNumber()));
        if (phoneExists) {
            throw new DuplicatePhoneNumberCheck("Phone number already exists.");
        }


    }
}
