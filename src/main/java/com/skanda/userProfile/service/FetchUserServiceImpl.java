package com.skanda.userProfile.service;

import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import com.skanda.userProfile.behaviour.UserNotFoundException;
import com.skanda.userProfile.entity.FetchUserResponse;
import com.skanda.userProfile.mappers.FetchUserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchUserServiceImpl implements FetchUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FetchUserMapping userMapping;

    @Override
    public FetchUserResponse fetchDetailsById(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No user found with ID: " + userId));

        return userMapping.userEntityToResponse(user);
    }
}
