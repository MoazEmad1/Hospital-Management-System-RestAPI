package com.example.hospital.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String name;
}
