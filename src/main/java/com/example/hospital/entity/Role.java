package com.example.hospital.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Role {
    @Id
    private Long roleId;
    private String name;
}
