package com.skanda.loginUser.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private Long userId;
    private String name;
    private String email;
    private String phone;
}
