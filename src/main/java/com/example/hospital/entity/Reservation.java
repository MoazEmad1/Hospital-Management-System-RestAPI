package com.example.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    @OneToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
}
