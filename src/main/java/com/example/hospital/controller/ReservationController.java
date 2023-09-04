package com.example.hospital.controller;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Reservation;
import com.example.hospital.entity.Role;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.RoleRepository;
import com.example.hospital.service.DoctorService;
import com.example.hospital.service.PatientService;
import com.example.hospital.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @GetMapping("/reservations")
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    public List<Reservation> getDoctorOrPatientReservations() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String username = authentication.getName();

            Role userRole = roleRepository.findByName(authentication.getAuthorities().stream().findFirst().orElse(null));

            if (userRole != null) {
                if (userRole.getName().equals("ROLE_DOCTOR")) {
                    return doctorService.getDoctorReservations(username);
                } else if (userRole.getName().equals("ROLE_PATIENT")) {
                    return patientService.getPatientReservations(username);
                }
            }
        }

        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR', 'ROLE_PATIENT')")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/make-appointment")
    @PreAuthorize("hasAnyRole('ROLE_PATIENT','ROLE_ADMIN')")
    public Reservation createDoctorAppointment(@RequestBody Reservation request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Patient> optionalPatient = patientRepository.findByEmailOrUsername(username,username);
        Patient patient = optionalPatient.orElse(null);
        if(patient == null){
            patient=request.getPatient();
        }
        Doctor doctor = request.getDoctor();
        LocalDate date = request.getDate();
        return reservationService.createDoctorAppointment(patient, doctor, date);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
