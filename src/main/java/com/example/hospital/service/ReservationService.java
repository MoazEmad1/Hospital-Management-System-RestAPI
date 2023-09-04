package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Reservation;
import com.example.hospital.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    public Reservation createDoctorAppointment(Patient patient, Doctor doctor, LocalDate date) {
        Reservation appointment = new Reservation();
        appointment.setDate(date);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.setNoOfAppointments(patient.getNoOfAppointments() + 1);
        return reservationRepository.save(appointment);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

