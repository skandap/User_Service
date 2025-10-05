package com.skanda.userProfile.service;

import com.skanda.util.entity.UserEntity;
import com.skanda.util.jwt.JwtUtil;
import com.skanda.util.repository.UserRepository;
import com.skanda.userProfile.behaviour.UserNotFoundException;
import com.skanda.userProfile.entity.FetchUserResponse;
import com.skanda.userProfile.mappers.FetchUserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchUserServiceImpl implements FetchUserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public FetchUserMapping userMapping;

    @Autowired
    public JwtUtil jwtUtil;

    @Override
    public FetchUserResponse fetchDetailsById(String authHeader) {
        String token = authHeader.replace("Bearer ", "").trim();
        Long userId = jwtUtil.getUserIdFromToken(token);
        UserEntity user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("No user found"));
        return userMapping.userEntityToResponse(user);
    }
}
