package com.skanda.userProfile.entity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FetchUserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private int age;
    private LocalDateTime createdAt;
}
