package com.skanda.InquireUserDetails.entity;
import com.skanda.util.entity.Enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InquireUserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    private LocalDateTime createdAt;
    private Status status;
}
