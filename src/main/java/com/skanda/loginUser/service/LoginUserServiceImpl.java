package com.skanda.loginUser.service;

import com.skanda.util.entity.UserEntity;
import com.skanda.util.jwt.JwtUtil;
import com.skanda.util.repository.UserRepository;
import com.skanda.loginUser.Mappers.LoginUserMapping;
import com.skanda.loginUser.behaviour.LoginUserNotFoundException;
import com.skanda.loginUser.entity.LoginUserRequest;
import com.skanda.loginUser.entity.LoginUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginUserServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public LoginUserMapping userMapping;

    @Autowired
    public JwtUtil jwtUtil;

    @Override
    public LoginUserResponse loginUser(LoginUserRequest userRequest) {
        UserEntity userEntity = userRepository.findByEmail(userRequest.getEmail())
                .orElseThrow(() -> new LoginUserNotFoundException("User not found"));
        if (!Objects.equals(userEntity.getPassword(), userRequest.getPassword())) {
            throw new LoginUserNotFoundException("Invalid Password");
        }
        String token = jwtUtil.generateToken(userEntity.getUserId());
        return userMapping.userEntityToResponse(userEntity,token);
    }
}
