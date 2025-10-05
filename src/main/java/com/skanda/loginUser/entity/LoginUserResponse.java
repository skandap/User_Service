package com.skanda.loginUser.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginUserResponse {
    public String token;
    public User user;
}
