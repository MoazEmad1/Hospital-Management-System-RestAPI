package com.example.hospital.repository;

import com.example.hospital.entity.Patient_Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientSurgeryRepository extends JpaRepository<Patient_Surgery, Long> {
}
