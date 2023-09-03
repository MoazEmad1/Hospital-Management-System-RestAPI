package com.example.hospital.service;

import com.example.hospital.dto.DoctorDto;
import com.example.hospital.entity.Role;
import com.example.hospital.repository.RoleRepository;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private RoleRepository roleRepository;


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    public Doctor registerDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setUsername(doctorDto.getUsername());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPassword(doctorDto.getPassword());
        doctor.setGender(doctorDto.getGender());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setDateOfBirth(doctorDto.getDateOfBirth());
        doctor.setSpecialization(doctorDto.getSpecialization());
        Role role = new Role();
        role.setRoleId(1L);
        role.setName("ROLE_DOCTOR");
        roleRepository.save(role);
        doctor.setRole(role);
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(DoctorDto doctorDto) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorDto.getId());
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();
            existingDoctor.setFirstName(doctorDto.getFirstName());
            existingDoctor.setLastName(doctorDto.getLastName());
            existingDoctor.setUsername(doctorDto.getUsername());
            existingDoctor.setGender(doctorDto.getGender());
            existingDoctor.setDateOfBirth(doctorDto.getDateOfBirth());
            existingDoctor.setEmail(doctorDto.getEmail());
            existingDoctor.setPassword(doctorDto.getPassword());
            existingDoctor.setPhoneNumber(doctorDto.getPhoneNumber());
            existingDoctor.setAddress(doctorDto.getAddress());
            existingDoctor.setDaysAvailable(doctorDto.getDaysAvailable());
            existingDoctor.setSpecialization(doctorDto.getSpecialization());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
