package com.example.hospital.mapper;

import com.example.hospital.dto.SurgeryDto;
import com.example.hospital.entity.Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SurgeryMapper {

    SurgeryDto surgeryToSurgeryDto(Surgery surgery);

    Surgery surgeryDtoToSurgery(SurgeryDto surgeryDto);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    void updateSurgeryFromDto(SurgeryDto surgeryDto, @MappingTarget Surgery surgery);
}
