package com.example.hospital.mapper;

import com.example.hospital.dto.SurgeryDto;
import com.example.hospital.entity.Surgery;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-14T20:55:46+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2-ea (Private Build)"
)
@Component
public class SurgeryMapperImpl implements SurgeryMapper {

    @Override
    public SurgeryDto surgeryToSurgeryDto(Surgery surgery) {
        if ( surgery == null ) {
            return null;
        }

        SurgeryDto surgeryDto = new SurgeryDto();

        surgeryDto.setId( surgery.getId() );
        surgeryDto.setType( surgery.getType() );

        return surgeryDto;
    }

    @Override
    public Surgery surgeryDtoToSurgery(SurgeryDto surgeryDto) {
        if ( surgeryDto == null ) {
            return null;
        }

        Surgery surgery = new Surgery();

        surgery.setId( surgeryDto.getId() );
        surgery.setType( surgeryDto.getType() );

        return surgery;
    }

    @Override
    public void updateSurgeryFromDto(SurgeryDto surgeryDto, Surgery surgery) {
        if ( surgeryDto == null ) {
            return;
        }

        surgery.setId( surgeryDto.getId() );
        surgery.setType( surgeryDto.getType() );
    }
}
