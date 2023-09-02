package com.example.hospital.service;

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


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();
            existingDoctor.setFirstName(updatedDoctor.getFirstName());
            existingDoctor.setLastName(updatedDoctor.getLastName());
            existingDoctor.setUsername(updatedDoctor.getUsername());
            existingDoctor.setGender(updatedDoctor.getGender());
            existingDoctor.setDateOfBirth(updatedDoctor.getDateOfBirth());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setPassword(updatedDoctor.getPassword());
            existingDoctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
            existingDoctor.setAddress(updatedDoctor.getAddress());
            existingDoctor.setRole(updatedDoctor.getRole());
            existingDoctor.setDaysAvailable(updatedDoctor.getDaysAvailable());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());

            return doctorRepository.save(existingDoctor);
        } else {
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
