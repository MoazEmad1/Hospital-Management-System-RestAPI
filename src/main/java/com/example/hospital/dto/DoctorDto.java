package com.example.hospital.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

import java.time.DayOfWeek;
import java.util.Set;

@Data
public class DoctorDto extends UserDto {
    @NotBlank(message = "Specialization is required")
    private String specialization;
    private Set<DayOfWeek> daysAvailable;
}
