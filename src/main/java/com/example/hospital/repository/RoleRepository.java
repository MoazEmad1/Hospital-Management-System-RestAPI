package com.example.hospital.repository;

import com.example.hospital.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(GrantedAuthority grantedAuthority);
}
