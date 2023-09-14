package com.example.hospital.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PatientDto extends UserDto{
    private int noOfAppointments=0;
}
