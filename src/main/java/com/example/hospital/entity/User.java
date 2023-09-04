package com.example.hospital.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId",nullable = false)
    private Role role;
}
