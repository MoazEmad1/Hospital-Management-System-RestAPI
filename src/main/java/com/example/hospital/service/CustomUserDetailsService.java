package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public CustomUserDetailsService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(email);
        Optional<Patient> patientOptional = patientRepository.findByEmail(email);

        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            return new User(doctor.getEmail(), doctor.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_DOCTOR")));
        } else if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            return new User(patient.getEmail(), patient.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_PATIENT")));
        } else {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
    }

}
