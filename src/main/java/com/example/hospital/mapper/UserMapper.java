package com.example.hospital.mapper;

import com.example.hospital.dto.AdminDto;
import com.example.hospital.dto.DoctorDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.dto.Patient_SurgeryDto;
import com.example.hospital.entity.Admin;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Patient_Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    AdminDto adminToAdminDto(Admin admin);

    DoctorDto doctorToDoctorDto(Doctor doctor);

    PatientDto patientToPatientDto(Patient patient);

    Patient_SurgeryDto patient_SurgeryToPatient_SurgeryDto(Patient_Surgery patient_surgery);

    Admin adminDtoToAdmin(AdminDto adminDto);

    Doctor doctorDtoToDoctor(DoctorDto doctorDto);

    Patient patientDtoToPatient(PatientDto patientDto);

    Patient_Surgery patient_SurgeryDtoToPatient_Surgery(Patient_SurgeryDto patient_surgery);

    @Mappings({
            @Mapping(target = "id", source = "doctorDto.id"),
            @Mapping(target = "firstName", source = "doctorDto.firstName"),
            @Mapping(target = "lastName", source = "doctorDto.lastName"),
            @Mapping(target = "username", source = "doctorDto.username"),
            @Mapping(target = "email", source = "doctorDto.email"),
            @Mapping(target = "password", source = "doctorDto.password"),
            @Mapping(target = "gender", source = "doctorDto.gender"),
            @Mapping(target = "phoneNumber", source = "doctorDto.phoneNumber"),
            @Mapping(target = "address", source = "doctorDto.address"),
            @Mapping(target = "dateOfBirth", source = "doctorDto.dateOfBirth"),
            @Mapping(target = "specialization", source = "doctorDto.specialization"),
            @Mapping(target = "daysAvailable", source = "doctorDto.daysAvailable")
    })
    Doctor updateDoctorFromDto(DoctorDto doctorDto, Doctor doctor);


    @Mappings({
            @Mapping(target = "id", source = "patientDto.id"),
            @Mapping(target = "firstName", source = "patientDto.firstName"),
            @Mapping(target = "lastName", source = "patientDto.lastName"),
            @Mapping(target = "username", source = "patientDto.username"),
            @Mapping(target = "email", source = "patientDto.email"),
            @Mapping(target = "password", source = "patientDto.password"),
            @Mapping(target = "gender", source = "patientDto.gender"),
            @Mapping(target = "phoneNumber", source = "patientDto.phoneNumber"),
            @Mapping(target = "address", source = "patientDto.address"),
            @Mapping(target = "dateOfBirth", source = "patientDto.dateOfBirth"),
            @Mapping(target = "noOfAppointments", source = "patientDto.noOfAppointments")
    })
    Patient updatePatientFromDto(PatientDto patientDto, Patient patient);

    @Mappings({
            @Mapping(target = "id", source = "adminDto.id"),
            @Mapping(target = "firstName", source = "adminDto.firstName"),
            @Mapping(target = "lastName", source = "adminDto.lastName"),
            @Mapping(target = "username", source = "adminDto.username"),
            @Mapping(target = "email", source = "adminDto.email"),
            @Mapping(target = "password", source = "adminDto.password"),
            @Mapping(target = "gender", source = "adminDto.gender"),
            @Mapping(target = "phoneNumber", source = "adminDto.phoneNumber"),
            @Mapping(target = "address", source = "adminDto.address"),
            @Mapping(target = "dateOfBirth", source = "adminDto.dateOfBirth")
    })
    Admin updateAdminFromDto(AdminDto adminDto, Admin admin);

    @Mappings({
            @Mapping(target = "id", source = "patientSurgeryDto.id"),
            @Mapping(target = "surgery", source = "patientSurgeryDto.surgery"),
            @Mapping(target = "patient", source = "patientSurgeryDto.patient"),
            @Mapping(target = "doctor", source = "patientSurgeryDto.doctor"),
            @Mapping(target = "room", source = "patientSurgeryDto.room"),
            @Mapping(target = "date", source = "patientSurgeryDto.date")
    })
    Patient_Surgery updatePatientSurgeryFromDto(Patient_SurgeryDto patientSurgeryDto, Patient_Surgery patientSurgery);

    List<Patient_SurgeryDto> patient_SurgeryListToPatient_SurgeryDtoList(List<Patient_Surgery> all);
}
