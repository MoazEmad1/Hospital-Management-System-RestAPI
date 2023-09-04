package com.example.hospital.service;

import com.example.hospital.dto.AdminDto;
import com.example.hospital.entity.Admin;
import com.example.hospital.entity.Role;
import com.example.hospital.mapper.UserMapper;
import com.example.hospital.repository.AdminRepository;
import com.example.hospital.repository.RoleRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    public List<AdminDto> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(userMapper::adminToAdminDto)
                .collect(Collectors.toList());
    }

    public AdminDto getAdminById(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        return optionalAdmin.map(userMapper::adminToAdminDto).orElse(null);
    }

    public AdminDto registerAdmin(AdminDto adminDto) {
        Admin admin = userMapper.adminDtoToAdmin(adminDto);
        Role role = new Role();
        role.setRoleId(3L);
        role.setName("ROLE_ADMIN");
        roleRepository.save(role);
        admin.setRole(role);
        return userMapper.adminToAdminDto(adminRepository.save(admin));
    }

    public AdminDto updateAdmin(AdminDto adminDto) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminDto.getId());
        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            userMapper.updateAdminFromDto(adminDto, existingAdmin);
            return userMapper.adminToAdminDto(adminRepository.save(existingAdmin));
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
