package com.example.hospital.mapper;

import com.example.hospital.dto.AdminDto;
import com.example.hospital.dto.DoctorDto;
import com.example.hospital.dto.PatientDto;
import com.example.hospital.dto.Patient_SurgeryDto;
import com.example.hospital.entity.Admin;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Patient_Surgery;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-14T20:55:47+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2-ea (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public AdminDto adminToAdminDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDto adminDto = new AdminDto();

        adminDto.setId( admin.getId() );
        adminDto.setFirstName( admin.getFirstName() );
        adminDto.setLastName( admin.getLastName() );
        adminDto.setUsername( admin.getUsername() );
        adminDto.setEmail( admin.getEmail() );
        adminDto.setPassword( admin.getPassword() );
        adminDto.setGender( admin.getGender() );
        adminDto.setPhoneNumber( admin.getPhoneNumber() );
        adminDto.setAddress( admin.getAddress() );
        adminDto.setDateOfBirth( admin.getDateOfBirth() );

        return adminDto;
    }

    @Override
    public DoctorDto doctorToDoctorDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDto doctorDto = new DoctorDto();

        doctorDto.setId( doctor.getId() );
        doctorDto.setFirstName( doctor.getFirstName() );
        doctorDto.setLastName( doctor.getLastName() );
        doctorDto.setUsername( doctor.getUsername() );
        doctorDto.setEmail( doctor.getEmail() );
        doctorDto.setPassword( doctor.getPassword() );
        doctorDto.setGender( doctor.getGender() );
        doctorDto.setPhoneNumber( doctor.getPhoneNumber() );
        doctorDto.setAddress( doctor.getAddress() );
        doctorDto.setDateOfBirth( doctor.getDateOfBirth() );
        doctorDto.setRole( doctor.getRole() );
        doctorDto.setSpecialization( doctor.getSpecialization() );
        Set<DayOfWeek> set = doctor.getDaysAvailable();
        if ( set != null ) {
            doctorDto.setDaysAvailable( new LinkedHashSet<DayOfWeek>( set ) );
        }

        return doctorDto;
    }

    @Override
    public PatientDto patientToPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        patientDto.setId( patient.getId() );
        patientDto.setFirstName( patient.getFirstName() );
        patientDto.setLastName( patient.getLastName() );
        patientDto.setUsername( patient.getUsername() );
        patientDto.setEmail( patient.getEmail() );
        patientDto.setPassword( patient.getPassword() );
        patientDto.setGender( patient.getGender() );
        patientDto.setPhoneNumber( patient.getPhoneNumber() );
        patientDto.setAddress( patient.getAddress() );
        patientDto.setDateOfBirth( patient.getDateOfBirth() );
        patientDto.setRole( patient.getRole() );
        patientDto.setNoOfAppointments( patient.getNoOfAppointments() );

        return patientDto;
    }

    @Override
    public Patient_SurgeryDto patient_SurgeryToPatient_SurgeryDto(Patient_Surgery patient_surgery) {
        if ( patient_surgery == null ) {
            return null;
        }

        Patient_SurgeryDto patient_SurgeryDto = new Patient_SurgeryDto();

        patient_SurgeryDto.setId( patient_surgery.getId() );
        patient_SurgeryDto.setSurgery( patient_surgery.getSurgery() );
        patient_SurgeryDto.setPatient( patient_surgery.getPatient() );
        patient_SurgeryDto.setDoctor( patient_surgery.getDoctor() );
        patient_SurgeryDto.setRoom( patient_surgery.getRoom() );
        patient_SurgeryDto.setDate( patient_surgery.getDate() );

        return patient_SurgeryDto;
    }

    @Override
    public Admin adminDtoToAdmin(AdminDto adminDto) {
        if ( adminDto == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setFirstName( adminDto.getFirstName() );
        admin.setLastName( adminDto.getLastName() );
        admin.setUsername( adminDto.getUsername() );
        admin.setEmail( adminDto.getEmail() );
        admin.setPassword( adminDto.getPassword() );
        admin.setGender( adminDto.getGender() );
        admin.setPhoneNumber( adminDto.getPhoneNumber() );
        admin.setAddress( adminDto.getAddress() );
        admin.setDateOfBirth( adminDto.getDateOfBirth() );
        admin.setId( adminDto.getId() );

        return admin;
    }

    @Override
    public Doctor doctorDtoToDoctor(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setFirstName( doctorDto.getFirstName() );
        doctor.setLastName( doctorDto.getLastName() );
        doctor.setUsername( doctorDto.getUsername() );
        doctor.setEmail( doctorDto.getEmail() );
        doctor.setPassword( doctorDto.getPassword() );
        doctor.setGender( doctorDto.getGender() );
        doctor.setPhoneNumber( doctorDto.getPhoneNumber() );
        doctor.setAddress( doctorDto.getAddress() );
        doctor.setDateOfBirth( doctorDto.getDateOfBirth() );
        doctor.setRole( doctorDto.getRole() );
        doctor.setId( doctorDto.getId() );
        Set<DayOfWeek> set = doctorDto.getDaysAvailable();
        if ( set != null ) {
            doctor.setDaysAvailable( new LinkedHashSet<DayOfWeek>( set ) );
        }
        doctor.setSpecialization( doctorDto.getSpecialization() );

        return doctor;
    }

    @Override
    public Patient patientDtoToPatient(PatientDto patientDto) {
        if ( patientDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setFirstName( patientDto.getFirstName() );
        patient.setLastName( patientDto.getLastName() );
        patient.setUsername( patientDto.getUsername() );
        patient.setEmail( patientDto.getEmail() );
        patient.setPassword( patientDto.getPassword() );
        patient.setGender( patientDto.getGender() );
        patient.setPhoneNumber( patientDto.getPhoneNumber() );
        patient.setAddress( patientDto.getAddress() );
        patient.setDateOfBirth( patientDto.getDateOfBirth() );
        patient.setRole( patientDto.getRole() );
        patient.setId( patientDto.getId() );
        patient.setNoOfAppointments( patientDto.getNoOfAppointments() );

        return patient;
    }

    @Override
    public Patient_Surgery patient_SurgeryDtoToPatient_Surgery(Patient_SurgeryDto patient_surgery) {
        if ( patient_surgery == null ) {
            return null;
        }

        Patient_Surgery patient_Surgery = new Patient_Surgery();

        patient_Surgery.setId( patient_surgery.getId() );
        patient_Surgery.setSurgery( patient_surgery.getSurgery() );
        patient_Surgery.setPatient( patient_surgery.getPatient() );
        patient_Surgery.setDoctor( patient_surgery.getDoctor() );
        patient_Surgery.setRoom( patient_surgery.getRoom() );
        patient_Surgery.setDate( patient_surgery.getDate() );

        return patient_Surgery;
    }

    @Override
    public Doctor updateDoctorFromDto(DoctorDto doctorDto, Doctor doctor) {
        if ( doctorDto == null && doctor == null ) {
            return null;
        }

        Doctor doctor1 = new Doctor();

        if ( doctorDto != null ) {
            doctor1.setId( doctorDto.getId() );
            doctor1.setFirstName( doctorDto.getFirstName() );
            doctor1.setLastName( doctorDto.getLastName() );
            doctor1.setUsername( doctorDto.getUsername() );
            doctor1.setEmail( doctorDto.getEmail() );
            doctor1.setPassword( doctorDto.getPassword() );
            doctor1.setGender( doctorDto.getGender() );
            doctor1.setPhoneNumber( doctorDto.getPhoneNumber() );
            doctor1.setAddress( doctorDto.getAddress() );
            doctor1.setDateOfBirth( doctorDto.getDateOfBirth() );
            doctor1.setRole( doctorDto.getRole() );
            doctor1.setSpecialization( doctorDto.getSpecialization() );
            Set<DayOfWeek> set = doctorDto.getDaysAvailable();
            if ( set != null ) {
                doctor1.setDaysAvailable( new LinkedHashSet<DayOfWeek>( set ) );
            }
        }

        return doctor1;
    }

    @Override
    public Patient updatePatientFromDto(PatientDto patientDto, Patient patient) {
        if ( patientDto == null && patient == null ) {
            return null;
        }

        Patient patient1 = new Patient();

        if ( patientDto != null ) {
            patient1.setId( patientDto.getId() );
            patient1.setFirstName( patientDto.getFirstName() );
            patient1.setLastName( patientDto.getLastName() );
            patient1.setUsername( patientDto.getUsername() );
            patient1.setEmail( patientDto.getEmail() );
            patient1.setPassword( patientDto.getPassword() );
            patient1.setGender( patientDto.getGender() );
            patient1.setPhoneNumber( patientDto.getPhoneNumber() );
            patient1.setAddress( patientDto.getAddress() );
            patient1.setDateOfBirth( patientDto.getDateOfBirth() );
            patient1.setRole( patientDto.getRole() );
            patient1.setNoOfAppointments( patientDto.getNoOfAppointments() );
        }

        return patient1;
    }

    @Override
    public Admin updateAdminFromDto(AdminDto adminDto, Admin admin) {
        if ( adminDto == null && admin == null ) {
            return null;
        }

        Admin admin1 = new Admin();

        if ( adminDto != null ) {
            admin1.setId( adminDto.getId() );
            admin1.setFirstName( adminDto.getFirstName() );
            admin1.setLastName( adminDto.getLastName() );
            admin1.setUsername( adminDto.getUsername() );
            admin1.setEmail( adminDto.getEmail() );
            admin1.setPassword( adminDto.getPassword() );
            admin1.setGender( adminDto.getGender() );
            admin1.setPhoneNumber( adminDto.getPhoneNumber() );
            admin1.setAddress( adminDto.getAddress() );
            admin1.setDateOfBirth( adminDto.getDateOfBirth() );
            admin1.setRole( adminDto.getRole() );
        }

        return admin1;
    }

    @Override
    public Patient_Surgery updatePatientSurgeryFromDto(Patient_SurgeryDto patientSurgeryDto, Patient_Surgery patientSurgery) {
        if ( patientSurgeryDto == null && patientSurgery == null ) {
            return null;
        }

        Patient_Surgery patient_Surgery = new Patient_Surgery();

        if ( patientSurgeryDto != null ) {
            patient_Surgery.setId( patientSurgeryDto.getId() );
            patient_Surgery.setSurgery( patientSurgeryDto.getSurgery() );
            patient_Surgery.setPatient( patientSurgeryDto.getPatient() );
            patient_Surgery.setDoctor( patientSurgeryDto.getDoctor() );
            patient_Surgery.setRoom( patientSurgeryDto.getRoom() );
            patient_Surgery.setDate( patientSurgeryDto.getDate() );
        }

        return patient_Surgery;
    }

    @Override
    public List<Patient_SurgeryDto> patient_SurgeryListToPatient_SurgeryDtoList(List<Patient_Surgery> all) {
        if ( all == null ) {
            return null;
        }

        List<Patient_SurgeryDto> list = new ArrayList<Patient_SurgeryDto>( all.size() );
        for ( Patient_Surgery patient_Surgery : all ) {
            list.add( patient_SurgeryToPatient_SurgeryDto( patient_Surgery ) );
        }

        return list;
    }
}
