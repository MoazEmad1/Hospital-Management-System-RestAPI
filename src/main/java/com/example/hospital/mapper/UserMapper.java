package com.example.hospital.mapper;

import com.example.hospital.dto.AdminDto;
import com.example.hospital.dto.DoctorDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.entity.Admin;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "noOfAppointments", ignore = true)
    })
    AdminDto adminToAdminDto(Admin admin);

    DoctorDto doctorToDoctorDto(Doctor doctor);

    PatientDto patientToPatientDto(Patient patient);

    Admin adminDtoToAdmin(AdminDto adminDto);

    Doctor doctorDtoToDoctor(DoctorDto doctorDto);

    Patient patientDtoToPatient(PatientDto patientDto);
    @Mapping(target = "role", ignore = true)
    void updateDoctorFromDto(DoctorDto doctorDto, @MappingTarget Doctor doctor);
    @Mapping(target = "role", ignore = true)
    void updatePatientFromDto(PatientDto patientDto,@MappingTarget Patient patient);
    @Mapping(target = "role", ignore = true)
    void updateAdminFromDto(AdminDto adminDto, @MappingTarget Admin admin);
}