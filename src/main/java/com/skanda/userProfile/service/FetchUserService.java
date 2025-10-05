package com.skanda.userProfile.service;

import com.skanda.userProfile.entity.FetchUserResponse;

public interface FetchUserService {

    FetchUserResponse fetchDetailsById(String authHeader);
}
