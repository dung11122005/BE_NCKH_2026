package com.example.nckh2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.nckh2026.domain.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>{
    
}
