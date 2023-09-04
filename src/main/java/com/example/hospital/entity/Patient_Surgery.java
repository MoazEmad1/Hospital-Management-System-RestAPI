package com.example.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
public class Patient_Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Surgery surgery;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Room room;
    private LocalDate date;
    public Patient_Surgery(Surgery surgery, Patient patient, Doctor doctor, Room room, LocalDate date) {
        this.surgery = surgery;
        this.patient = patient;
        this.doctor = doctor;
        this.room = room;
        this.date = date;
    }
}
