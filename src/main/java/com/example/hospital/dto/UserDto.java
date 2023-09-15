package com.example.hospital.dto;

import com.example.hospital.entity.Gender;
import com.example.hospital.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDto {
    private Long id;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Username is required")
    private String username;
    @Email(message = "Invalid email format")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format")
    private String phoneNumber;
    @NotBlank(message = "Address is required")
    private String address;
    private LocalDate dateOfBirth;
}
