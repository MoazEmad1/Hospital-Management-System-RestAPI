package com.example.hospital.controller;

import com.example.hospital.dto.SurgeryDto;
import com.example.hospital.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT', 'ROLE_ADMIN')")
    public List<SurgeryDto> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT', 'ROLE_ADMIN')")
    public SurgeryDto getSurgeryById(@PathVariable Long id) {
        return surgeryService.getSurgeryById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SurgeryDto createSurgery(@RequestBody SurgeryDto surgeryDto) {
        return surgeryService.createSurgery(surgeryDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SurgeryDto updateSurgery(@PathVariable Long id, @RequestBody SurgeryDto updatedSurgeryDto) {
        return surgeryService.updateSurgery(id, updatedSurgeryDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteSurgery(id);
    }
}
