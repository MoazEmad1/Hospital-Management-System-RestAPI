package com.example.hospital.controller;

import com.example.hospital.entity.Surgery;
import com.example.hospital.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

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
