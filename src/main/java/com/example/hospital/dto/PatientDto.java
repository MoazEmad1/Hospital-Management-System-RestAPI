package com.example.hospital.dto;

import lombok.Data;

@Data
public class PatientDto extends UserDto{
    private int noOfAppointments=0;
}
