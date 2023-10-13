package com.example.hospital.repository;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Reservation;
import com.example.hospital.entity.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByDoctor(Doctor doctor);

    @Query("SELECT r FROM Reservation r WHERE r.patient = :patient")
    List<Reservation> getPatientReservations(Patient patient);
    Optional<Reservation> getReservationByDoctorAndPatientAndDate(Doctor doctor, Patient patient, ReservationDate date);
}
