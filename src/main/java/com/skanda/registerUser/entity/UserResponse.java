package com.skanda.registerUser.entity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private int age;
    private LocalDateTime createdAt;
}
