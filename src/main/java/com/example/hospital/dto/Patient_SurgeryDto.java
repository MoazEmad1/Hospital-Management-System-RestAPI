package com.example.hospital.dto;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Room;
import com.example.hospital.entity.Surgery;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Patient_SurgeryDto {
    private Long id;
    private Surgery surgery;
    private Patient patient;
    private Doctor doctor;
    private Room room;
    private LocalDate date;
}
