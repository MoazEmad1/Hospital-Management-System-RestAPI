package com.example.hospital.repository;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByDoctor(Doctor doctor);

    @Query("SELECT r FROM Reservation r WHERE r.patient = :patient")
    List<Reservation> getPatientReservations(Patient patient);
}
