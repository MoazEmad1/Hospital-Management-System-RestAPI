package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Reservation;
import com.example.hospital.entity.ReservationDate;
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
        if(!doctor.getDaysAvailable().contains(date.getDayOfWeek())) {
            return null;
        }
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setDate(date);
        Optional<Reservation> reservationOp=reservationRepository.getReservationByDoctorAndPatientAndDate(doctor,patient,reservationDate);
        Reservation reservation = new Reservation();
        if(reservationOp.isPresent()) {
            reservation = reservationOp.get();
        }else {
            reservation.setDate(reservationDate);
            reservation.setDoctor(doctor);
            reservation.setPatient(patient);
        }
        reservation.getDate().setCount(reservation.getDate().getCount()+1);
        patient.setNoOfAppointments(patient.getNoOfAppointments() + 1);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

