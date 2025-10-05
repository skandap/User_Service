package com.skanda.InquireUserDetails.mappers;


import com.skanda.InquireUserDetails.entity.InquireUserResponse;
import com.skanda.util.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InquireUserMapping {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "status", target = "status")
    InquireUserResponse userEntityToResponse(UserEntity user);
}
