package com.skanda.InquireUserDetails.service;

import com.skanda.InquireUserDetails.entity.InquireUserResponse;

public interface InquireUserService {

    InquireUserResponse inquireUserDetailsById(Long userId);
}
