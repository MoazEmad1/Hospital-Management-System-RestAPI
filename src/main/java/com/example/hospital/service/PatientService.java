package com.example.hospital.service;

import com.example.hospital.dto.PatientDto;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Role;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public Patient registerPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setUsername(patientDto.getUsername());
        patient.setEmail(patientDto.getEmail());
        String encodedPassword = passwordEncoder.encode(patientDto.getPassword());
        patient.setPassword(encodedPassword);
        patient.setGender(patientDto.getGender());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setAddress(patientDto.getAddress());
        patient.setDateOfBirth(patientDto.getDateOfBirth());

        Role role = new Role();
        role.setRoleId(2L);
        role.setName("ROLE_PATIENT");
        roleRepository.save(role);
        patient.setRole(role);
        return patientRepository.save(patient);
    }


    public Patient updatePatient(PatientDto patientDto) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientDto.getId());
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setFirstName(patientDto.getFirstName());
            existingPatient.setLastName(patientDto.getLastName());
            existingPatient.setUsername(patientDto.getUsername());
            existingPatient.setGender(patientDto.getGender());
            existingPatient.setDateOfBirth(patientDto.getDateOfBirth());
            existingPatient.setEmail(patientDto.getEmail());
            existingPatient.setPassword(patientDto.getPassword());
            existingPatient.setPhoneNumber(patientDto.getPhoneNumber());
            existingPatient.setAddress(patientDto.getAddress());
            existingPatient.setNoOfAppointments(patientDto.getNoOfAppointments());
            return patientRepository.save(existingPatient);
        }
        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
