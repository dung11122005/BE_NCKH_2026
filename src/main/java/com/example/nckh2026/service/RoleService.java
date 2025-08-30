package com.example.nckh2026.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.nckh2026.domain.Role;
import com.example.nckh2026.repository.RoleRepository;



@Service
public class RoleService {
    
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public Role fetchById(long id) {
        Optional<Role> roleOptional = this.roleRepository.findById(id);
        if (roleOptional.isPresent())
            return roleOptional.get();
        return null;
    }
}
