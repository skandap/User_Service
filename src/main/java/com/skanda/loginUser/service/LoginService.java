package com.skanda.loginUser.service;

import com.skanda.loginUser.entity.LoginUserRequest;
import com.skanda.loginUser.entity.LoginUserResponse;

public interface LoginService {

    LoginUserResponse loginUser(LoginUserRequest userRequest);
}
