package com.skanda.registerUser.entity;

import com.skanda.util.entity.Role;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRequest {

    @NotNull(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Za-z ]{1,100}$", message = "Name must contain only letters and spaces, and be 1 to 100 characters long")
    private String name;

    @NotNull(message = "Email is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email must be a valid format (e.g., example@domain.com)")
    private String email;

    @NotNull(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Phone number must contain 10 to 15 digits and can start with +")
    private String phoneNumber;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age must be lesser than 120")
    private int age;

    @NotNull(message = "Password is mandatory")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,36}$", message = "Password must be 8–36 characters, include uppercase, lowercase, digit, and special character, and contain no spaces")
    private String password;

    private Role role;
}
