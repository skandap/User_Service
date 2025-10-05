package com.skanda.InquireUserList.service;

import com.skanda.InquireUserList.entity.InquireUserListResponse;
import com.skanda.InquireUserList.mappers.InquireUserListMapping;
import com.skanda.util.entity.UserEntity;
import com.skanda.util.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InquireUserListServiceImpl implements InquireUserListService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public InquireUserListMapping userMapping;

    @Override
    public List<InquireUserListResponse> inquireUserList(String status) {
        List<UserEntity> userList = userRepository.findAll();
        List<InquireUserListResponse> inquireUserListResponses = userMapping.userEntityToResponse(userList);
        return inquireUserListResponses.stream().filter(user -> status == null || user.getStatus().name().equalsIgnoreCase(status)).collect(Collectors.toList());
    }
}
