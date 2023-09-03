package com.example.hospital.controller;

import com.example.hospital.entity.*;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.hospital.config.JwtProvider;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        Optional<Doctor> doctorOptional = doctorRepository.findByEmailOrUsername(username, username);
        Optional<Patient> patientOptional = patientRepository.findByEmailOrUsername(username, username);

        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), doctor.getPassword())) {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword())
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(username);

                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

                if (jwtProvider.validateToken(jwt, userDetails)) {
                    return ResponseEntity.ok(new JwtResponse(jwt));
                }
            }
        } else if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), patient.getPassword())) {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword())
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(username);

                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

                if (jwtProvider.validateToken(jwt, userDetails)) {
                    return ResponseEntity.ok(new JwtResponse(jwt));
                }
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }
}
