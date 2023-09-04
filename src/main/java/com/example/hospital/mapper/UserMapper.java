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
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "noOfAppointments", ignore = true)
    })
    AdminDto adminToAdminDto(Admin admin);

    DoctorDto doctorToDoctorDto(Doctor doctor);

    PatientDto patientToPatientDto(Patient patient);
    Patient_SurgeryDto patient_SurgeryToPatient_SurgeryDto(Patient_Surgery patient_surgery);

    Admin adminDtoToAdmin(AdminDto adminDto);

    Doctor doctorDtoToDoctor(DoctorDto doctorDto);

    Patient patientDtoToPatient(PatientDto patientDto);
    Patient_Surgery patient_SurgeryDtoToPatient_Surgery(Patient_SurgeryDto patient_surgery);
    @Mapping(target = "role", ignore = true)
    void updateDoctorFromDto(DoctorDto doctorDto, @MappingTarget Doctor doctor);
    @Mapping(target = "role", ignore = true)
    void updatePatientFromDto(PatientDto patientDto,@MappingTarget Patient patient);
    @Mapping(target = "role", ignore = true)
    void updateAdminFromDto(AdminDto adminDto, @MappingTarget Admin admin);

    void updatePatientSurgeryFromDto(Patient_SurgeryDto patientSurgeryDto, Patient_Surgery updatedSurgery);

    List<Patient_SurgeryDto> patient_SurgeryListToPatient_SurgeryDtoList(List<Patient_Surgery> all);
}