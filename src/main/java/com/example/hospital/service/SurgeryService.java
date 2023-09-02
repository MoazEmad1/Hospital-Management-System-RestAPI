package com.example.hospital.service;

import com.example.hospital.entity.Surgery;
import com.example.hospital.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Surgery getSurgeryById(Long id) {
        Optional<Surgery> surgery = surgeryRepository.findById(id);
        return surgery.orElse(null);
    }

    public Surgery createSurgery(Surgery newSurgery) {
        return surgeryRepository.save(newSurgery);
    }

    public Surgery updateSurgery(Long id, Surgery updatedSurgery) {
        Optional<Surgery> surgery = surgeryRepository.findById(id);
        if (surgery.isPresent()) {
            updatedSurgery.setId(id);
            return surgeryRepository.save(updatedSurgery);
        }
        return null;
    }

    public void deleteSurgery(Long id) {
        surgeryRepository.deleteById(id);
    }
}
