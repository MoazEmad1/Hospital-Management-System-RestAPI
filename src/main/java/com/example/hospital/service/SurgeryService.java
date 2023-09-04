package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Surgery;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public List<Surgery> getDoctorSurgeries(String doctorUsername) {
        Doctor doctor = doctorRepository.findByEmailOrUsername(doctorUsername,doctorUsername).orElseThrow();
        return surgeryRepository.findByDoctor(doctor);
    }

    public List<Surgery> getPatientSurgeries(String patientUsername) {
        Patient patient = patientRepository.findByEmailOrUsername(patientUsername,patientUsername).orElseThrow();
        return surgeryRepository.findByPatient(patient);
    }

    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Surgery getSurgeryById(Long id) {
        Optional<Surgery> surgery = surgeryRepository.findById(id);
        return surgery.orElse(null);
    }

    public Surgery createSurgery(Patient patient, Doctor doctor, LocalDate date) {
        Surgery newSurgery = new Surgery();
        newSurgery.setDate(date);
        newSurgery.setPatient(patient);
        newSurgery.setDoctor(doctor);
        patient.setNoOfAppointments(patient.getNoOfAppointments() + 1);
        return surgeryRepository.save(newSurgery);
    }

    public Surgery updateSurgery(Long id, Surgery updatedSurgery) {
        Optional<Surgery> surgery = surgeryRepository.findById(id);
        if (surgery.isPresent()) {
            updatedSurgery.setId(id);
            return surgeryRepository.save(updatedSurgery);
        }
        return null;
    }

    public void deleteSurgery(Long id) {
        surgeryRepository.deleteById(id);
    }
}
