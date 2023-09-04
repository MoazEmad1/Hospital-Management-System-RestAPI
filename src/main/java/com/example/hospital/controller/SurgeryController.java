package com.example.hospital.controller;

import com.example.hospital.entity.Role;
import com.example.hospital.entity.Surgery;
import com.example.hospital.repository.RoleRepository;
import com.example.hospital.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;
    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/surgeries")
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    public List<Surgery> getDoctorOrPatientSurgeries() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String username = authentication.getName();

            Role userRole = roleRepository.findByName(authentication.getAuthorities().stream().findFirst().orElse(null));

            if (userRole != null) {
                if (userRole.getName().equals("ROLE_DOCTOR")) {
                    return surgeryService.getDoctorSurgeries(username);
                } else if (userRole.getName().equals("ROLE_PATIENT")) {
                    return surgeryService.getPatientSurgeries(username);
                }
            }
        }

        return Collections.emptyList();
    }

    @GetMapping
    public List<Surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }

    @GetMapping("/{id}")
    public Surgery getSurgeryById(@PathVariable Long id) {
        return surgeryService.getSurgeryById(id);
    }

    @PostMapping
    public Surgery createSurgery(@RequestBody Surgery surgery) {
        return surgeryService.createSurgery(surgery);
    }

    @PutMapping("/{id}")
    public Surgery updateSurgery(@PathVariable Long id, @RequestBody Surgery updatedSurgery) {
        return surgeryService.updateSurgery(id, updatedSurgery);
    }

    @DeleteMapping("/{id}")
    public void deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteSurgery(id);
    }
}
