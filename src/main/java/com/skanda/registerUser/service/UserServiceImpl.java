package com.skanda.registerUser.service;

import com.skanda.registerUser.Mappers.UserMapping;
import com.skanda.registerUser.behavior.BothEmailPh;
import com.skanda.registerUser.behavior.DuplicateEmailCheck;
import com.skanda.registerUser.behavior.DuplicatePhoneNumberCheck;
import com.skanda.registerUser.entity.UserRequest;
import com.skanda.registerUser.entity.UserResponse;
import com.skanda.util.repository.UserRepository;
import com.skanda.util.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapping userMapping;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        try {
            if (userRepository.existsByEmailAndPhoneNumber(userRequest.getEmail(), userRequest.getPhoneNumber())) {
                throw new BothEmailPh("Email and Phone number already exists.");
            }
            if (userRepository.existsByEmail(userRequest.getEmail())) {
                throw new DuplicateEmailCheck("Email already exists.");
            }
            if (userRepository.existsByPhoneNumber(userRequest.getPhoneNumber())) {
                throw new DuplicatePhoneNumberCheck("Phone number already exists.");
            }

            UserEntity user = userMapping.userRequestToEntity(userRequest);
            UserEntity saved = userRepository.save(user);
            return userMapping.userEntityToResponse(saved);
        } catch (Exception e) {
            e.printStackTrace(); // this will print the exact cause in console
            throw new RuntimeException("Failed to register user: " + e.getMessage());
        }
    }

}
