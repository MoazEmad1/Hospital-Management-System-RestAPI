package com.example.hospital.dto;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDto {
    private LocalDate date;
    @OneToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
}
