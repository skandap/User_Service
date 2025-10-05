package com.skanda.InquireUserList.entity;
import com.skanda.util.entity.Status;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InquireUserListResponse {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    private LocalDateTime createdAt;
    private Status status;
}
