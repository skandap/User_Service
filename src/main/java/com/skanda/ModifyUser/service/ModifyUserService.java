package com.skanda.ModifyUser.service;

import com.skanda.ModifyUser.entity.ModifyUserRequest;
import com.skanda.ModifyUser.entity.ModifyUserResponse;
import com.skanda.userProfile.entity.FetchUserResponse;

public interface ModifyUserService {

    ModifyUserResponse modifyDetailsById(Long userId, ModifyUserRequest modifyUserRequest);
}
