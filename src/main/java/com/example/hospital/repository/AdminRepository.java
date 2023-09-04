package com.example.hospital.repository;

import com.example.hospital.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmailOrUsername(String email, String username);

}
