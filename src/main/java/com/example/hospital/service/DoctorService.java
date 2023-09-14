package com.example.hospital.service;

import com.example.hospital.mapper.UserMapper;
import com.example.hospital.dto.DoctorDto;
import com.example.hospital.entity.Reservation;
import com.example.hospital.entity.Role;
import com.example.hospital.repository.ReservationRepository;
import com.example.hospital.repository.RoleRepository;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;


    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(userMapper::doctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public DoctorDto getDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.map(userMapper::doctorToDoctorDto).orElse(null);
    }

    public DoctorDto registerDoctor(DoctorDto doctorDto) {
        Doctor doctor = userMapper.doctorDtoToDoctor(doctorDto);
        Role role = new Role();
        role.setRoleId(1L);
        role.setName("ROLE_DOCTOR");
        roleRepository.save(role);
        doctor.setRole(role);
        return userMapper.doctorToDoctorDto(doctorRepository.save(doctor));
    }

    public DoctorDto updateDoctor(DoctorDto doctorDto) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorDto.getId());
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();
            Doctor updatedDoctor = userMapper.updateDoctorFromDto(doctorDto, existingDoctor);
            return userMapper.doctorToDoctorDto(doctorRepository.save(updatedDoctor));
        }
        return null;
    }
    public List<Reservation> getDoctorReservations(String doctorUsername) {
        Doctor doctor = doctorRepository.findByEmailOrUsername(doctorUsername,doctorUsername).orElseThrow();
        return reservationRepository.findAllByDoctor(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
