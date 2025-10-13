package com.skanda.InquireUserDetails.service;

import com.skanda.InquireUserDetails.entity.InquireUserResponse;
import com.skanda.InquireUserDetails.mappers.InquireUserMapping;
import com.skanda.userProfile.behaviour.UserNotFoundException;
import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquireUserServiceImpl implements InquireUserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public InquireUserMapping userMapping;

    @Override
    public InquireUserResponse inquireUserDetailsById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("No user found"));
        return userMapping.userEntityToResponse(user);
    }
}
