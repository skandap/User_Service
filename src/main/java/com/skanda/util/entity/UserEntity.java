package com.skanda.util.entity;

import com.skanda.util.entity.Enums.Role;
import com.skanda.util.entity.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user_service")
public class UserEntity {

    @Id
    private Long userId;

    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    public void prePersist() {
        if (this.userId == null) {
            this.userId = ThreadLocalRandom.current().nextLong(10000000L, 99999999L);
        }
        if (this.status == null) {
            this.status = Status.ACTIVE;
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}
