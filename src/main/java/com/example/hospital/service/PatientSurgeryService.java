package com.example.hospital.service;

import com.example.hospital.entity.*;
import com.example.hospital.repository.PatientSurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientSurgeryService {
    @Autowired
    private PatientSurgeryRepository patientSurgeryRepository;
    public Patient_Surgery createPatientSurgery(Patient patient, Surgery surgery, Doctor doctor, Room room) {
        Patient_Surgery patientSurgery = new Patient_Surgery();
        patientSurgery.setPatient(patient);
        patientSurgery.setSurgery(surgery);
        patientSurgery.setDoctor(doctor);
        patientSurgery.setRoom(room);

        return patientSurgeryRepository.save(patientSurgery);
    }
}
