package com.example.hospital.service;

import com.example.hospital.mapper.UserMapper;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Reservation;
import com.example.hospital.entity.Role;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.ReservationRepository;
import com.example.hospital.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ReservationRepository reservationRepository;

    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(userMapper::patientToPatientDto)
                .collect(Collectors.toList());
    }

    public PatientDto getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.map(userMapper::patientToPatientDto).orElse(null);
    }

    public PatientDto registerPatient(PatientDto patientDto) {
        Patient patient = userMapper.patientDtoToPatient(patientDto);
        Role role = new Role();
        role.setRoleId(2L);
        role.setName("ROLE_PATIENT");
        roleRepository.save(role);
        patient.setRole(role);
        return userMapper.patientToPatientDto(patientRepository.save(patient));
    }


    public PatientDto updatePatient(PatientDto patientDto) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientDto.getId());
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            Patient updatedPatient = userMapper.updatePatientFromDto(patientDto, existingPatient);
            return userMapper.patientToPatientDto(patientRepository.save(updatedPatient));
        }
        return null;
    }

    public List<Reservation> getPatientReservations(String patientUsername) {
        Patient patient = patientRepository.findByEmailOrUsername(patientUsername,patientUsername).orElse(null);
        return reservationRepository.getPatientReservations(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
