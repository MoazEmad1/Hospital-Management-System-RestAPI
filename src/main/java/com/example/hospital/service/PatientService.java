package com.example.hospital.service;

import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setFirstName(updatedPatient.getFirstName());
            existingPatient.setLastName(updatedPatient.getLastName());
            existingPatient.setUsername(updatedPatient.getUsername());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setPassword(updatedPatient.getPassword());
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
            existingPatient.setAddress(updatedPatient.getAddress());
            existingPatient.setRole(updatedPatient.getRole());
            return patientRepository.save(updatedPatient);
        }
        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
