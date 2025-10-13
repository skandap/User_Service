package com.skanda.loginUser.service;

import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import com.skanda.util.jwt.JwtService;
import com.skanda.loginUser.Mappers.LoginUserMapping;
import com.skanda.loginUser.behaviour.LoginUserNotFoundException;
import com.skanda.loginUser.entity.LoginUserRequest;
import com.skanda.loginUser.entity.LoginUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginUserMapping userMapping;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginUserResponse loginUser(LoginUserRequest userRequest) {
        UserEntity userEntity = userRepository.findByEmail(userRequest.getEmail())
                .orElseThrow(() -> new LoginUserNotFoundException("User not found"));

        if (!userRequest.getPassword().equals(userEntity.getPassword())) {
            throw new LoginUserNotFoundException("Invalid Password");
        }


        // Generate JWT token dynamically
        String token = jwtService.generateToken(userEntity.getUserId(), userEntity.getRole().name());
        return userMapping.userEntityToResponse(userEntity, token);
    }
}
