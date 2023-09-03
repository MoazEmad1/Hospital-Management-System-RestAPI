package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.hospital.config.UserDetailsImpl;


import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmailOrUsername(email, email);
        Optional<Patient> patientOptional = patientRepository.findByEmailOrUsername(email, email);

        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            return UserDetailsImpl.build(doctor);
        } else if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            return UserDetailsImpl.build(patient);
        } else {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
    }
}

