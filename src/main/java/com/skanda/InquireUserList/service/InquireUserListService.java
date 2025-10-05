package com.skanda.InquireUserList.service;

import com.skanda.InquireUserList.entity.InquireUserListResponse;

import java.util.List;

public interface InquireUserListService {

    List<InquireUserListResponse> inquireUserList(String status);
}
