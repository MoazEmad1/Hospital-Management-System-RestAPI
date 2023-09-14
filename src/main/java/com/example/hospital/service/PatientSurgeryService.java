package com.example.hospital.service;

import com.example.hospital.mapper.UserMapper;
import com.example.hospital.dto.Patient_SurgeryDto;
import com.example.hospital.entity.*;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.PatientSurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientSurgeryService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientSurgeryRepository patientSurgeryRepository;
    @Autowired
    private UserMapper userMapper;

    public List<Patient_SurgeryDto> getDoctorSurgeries(String doctorUsername) {
        Doctor doctor = doctorRepository.findByEmailOrUsername(doctorUsername,doctorUsername).orElseThrow();
        return userMapper.patient_SurgeryListToPatient_SurgeryDtoList(patientSurgeryRepository.findByDoctor(doctor));
    }

    public List<Patient_SurgeryDto> getPatientSurgeries(String patientUsername) {
        Patient patient = patientRepository.findByEmailOrUsername(patientUsername,patientUsername).orElseThrow();
        return userMapper.patient_SurgeryListToPatient_SurgeryDtoList(patientSurgeryRepository.findByPatient(patient));
    }

    public List<Patient_SurgeryDto> getAllPatientSurgeries() {
        return userMapper.patient_SurgeryListToPatient_SurgeryDtoList(patientSurgeryRepository.findAll());
    }

    public Patient_SurgeryDto getPatientSurgeryById(Long id) {
        Optional<Patient_Surgery> surgery = patientSurgeryRepository.findById(id);
        return surgery.map(userMapper::patient_SurgeryToPatient_SurgeryDto).orElse(null);
    }

    public Patient_SurgeryDto createPatientSurgery(Patient_SurgeryDto request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Patient> optionalPatient = patientRepository.findByEmailOrUsername(username, username);
        Patient patient = optionalPatient.orElse(null);

        if (patient == null) {
            patient = request.getPatient();
        }

        Doctor doctor = request.getDoctor();
        LocalDate date = request.getDate();
        Room room = request.getRoom();
        Surgery surgery = request.getSurgery();

        if (patient != null) {
            patient.setNoOfAppointments(patient.getNoOfAppointments() + 1);
            patientRepository.save(patient);
        }

        Patient_Surgery patientSurgery = new Patient_Surgery(surgery, patient, doctor, room, date);

        return userMapper.patient_SurgeryToPatient_SurgeryDto(patientSurgeryRepository.save(patientSurgery));
    }


    public Patient_SurgeryDto updatePatient_Surgery(Long id, Patient_SurgeryDto patientSurgeryDto) {
        Optional<Patient_Surgery> patientSurgery = patientSurgeryRepository.findById(id);
        if (patientSurgery.isPresent()) {
            Patient_Surgery updatedSurgery = patientSurgery.get();
            updatedSurgery = userMapper.updatePatientSurgeryFromDto(patientSurgeryDto, updatedSurgery);
            updatedSurgery = patientSurgeryRepository.save(updatedSurgery);
            return userMapper.patient_SurgeryToPatient_SurgeryDto(updatedSurgery);
        }
        return null;
    }

    public void deletePatient_Surgery(Long id) {
        patientSurgeryRepository.deleteById(id);
    }
}
