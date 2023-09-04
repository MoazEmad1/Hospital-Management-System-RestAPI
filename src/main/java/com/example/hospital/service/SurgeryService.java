package com.example.hospital.service;

import com.example.hospital.dto.SurgeryDto;
import com.example.hospital.entity.Surgery;
import com.example.hospital.mapper.SurgeryMapper;
import com.example.hospital.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Autowired
    private SurgeryMapper surgeryMapper;

    public List<SurgeryDto> getAllSurgeries() {
        List<Surgery> surgeries = surgeryRepository.findAll();
        return surgeries.stream()
                .map(surgeryMapper::surgeryToSurgeryDto)
                .collect(Collectors.toList());
    }

    public SurgeryDto getSurgeryById(Long id) {
        Optional<Surgery> optionalSurgery = surgeryRepository.findById(id);
        return optionalSurgery.map(surgeryMapper::surgeryToSurgeryDto).orElse(null);
    }

    public SurgeryDto createSurgery(SurgeryDto surgeryDto) {
        Surgery surgery = surgeryMapper.surgeryDtoToSurgery(surgeryDto);
        Surgery savedSurgery = surgeryRepository.save(surgery);
        return surgeryMapper.surgeryToSurgeryDto(savedSurgery);
    }

    public SurgeryDto updateSurgery(Long id, SurgeryDto updatedSurgeryDto) {
        Optional<Surgery> optionalSurgery = surgeryRepository.findById(id);
        if (optionalSurgery.isPresent()) {
            Surgery existingSurgery = optionalSurgery.get();
            surgeryMapper.updateSurgeryFromDto(updatedSurgeryDto, existingSurgery);
            Surgery updatedSurgery = surgeryRepository.save(existingSurgery);
            return surgeryMapper.surgeryToSurgeryDto(updatedSurgery);
        }
        return null;
    }

    public void deleteSurgery(Long id) {
        surgeryRepository.deleteById(id);
    }
}
