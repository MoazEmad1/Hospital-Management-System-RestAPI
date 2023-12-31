package com.example.hospital.mapper;

import com.example.hospital.dto.SurgeryDto;
import com.example.hospital.entity.Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SurgeryMapper {
    SurgeryMapper INSTANCE = Mappers.getMapper(SurgeryMapper.class);

    SurgeryDto surgeryToSurgeryDto(Surgery surgery);

    Surgery surgeryDtoToSurgery(SurgeryDto surgeryDto);


    void updateSurgeryFromDto(SurgeryDto surgeryDto, @MappingTarget Surgery surgery);
}
