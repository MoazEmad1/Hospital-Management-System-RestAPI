package com.example.hospital.controller;

import com.example.hospital.dto.Patient_SurgeryDto;
import com.example.hospital.entity.*;
import com.example.hospital.repository.RoleRepository;
import com.example.hospital.service.PatientSurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-surgeries")
public class PatientSurgeryController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PatientSurgeryService patientSurgeryService;

    @GetMapping("/doctor-surgeries")
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    public List<Patient_SurgeryDto> getDoctorSurgeries() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return patientSurgeryService.getDoctorSurgeries(username);
    }

    @GetMapping("/patient-surgeries")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<Patient_SurgeryDto> getPatientSurgeries() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return patientSurgeryService.getPatientSurgeries(username);
    }


    @GetMapping
    public List<Patient_SurgeryDto> getAllPatientSurgeries() {
        return patientSurgeryService.getAllPatientSurgeries();
    }

    @GetMapping("/{id}")
    public Patient_SurgeryDto getPatientSurgeryById(@PathVariable Long id) {
        return patientSurgeryService.getPatientSurgeryById(id);
    }

    @PostMapping("/create-surgery")
    @PreAuthorize("hasAnyRole('ROLE_PATIENT', 'ROLE_ADMIN')")
    public Patient_SurgeryDto createSurgery(@RequestBody Patient_SurgeryDto request) {
        return patientSurgeryService.createPatientSurgery(request);
    }

    @PutMapping("/{id}")
    public Patient_SurgeryDto updatePatientSurgery(@PathVariable Long id, @RequestBody Patient_SurgeryDto patientSurgeryDto) {
        return patientSurgeryService.updatePatient_Surgery(id, patientSurgeryDto);
    }

    @DeleteMapping("/{id}")
    public void deletePatientSurgery(@PathVariable Long id) {
        patientSurgeryService.deletePatient_Surgery(id);
    }
}
