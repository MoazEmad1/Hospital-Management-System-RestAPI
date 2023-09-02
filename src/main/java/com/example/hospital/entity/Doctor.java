package com.example.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
public class Doctor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Set<DayOfWeek> daysAvailable;
    private String specialization;
}
