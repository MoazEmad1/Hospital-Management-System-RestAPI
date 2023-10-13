package com.example.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private ReservationDate date;
    @OneToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
}
