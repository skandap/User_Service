package com.skanda.registerUser.service;

import com.skanda.registerUser.entity.UserRequest;
import com.skanda.registerUser.entity.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
}
