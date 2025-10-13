package com.skanda.registerUser.entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserResponse {

    public String message;
    public Long userId;

}
