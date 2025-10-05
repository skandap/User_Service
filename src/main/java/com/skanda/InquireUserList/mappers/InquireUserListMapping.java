package com.skanda.InquireUserList.mappers;

import com.skanda.InquireUserList.entity.InquireUserListResponse;
import com.skanda.util.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InquireUserListMapping {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "status", target = "status")
    InquireUserListResponse userEntityToResponse(UserEntity user);

    List<InquireUserListResponse> userEntityToResponse(List<UserEntity> users);
}
