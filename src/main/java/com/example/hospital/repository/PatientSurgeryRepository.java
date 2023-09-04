package com.example.hospital.repository;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Patient_Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientSurgeryRepository extends JpaRepository<Patient_Surgery, Long> {
    List<Patient_Surgery> findByPatient(Patient patient);

    List<Patient_Surgery> findByDoctor(Doctor doctor);
}
