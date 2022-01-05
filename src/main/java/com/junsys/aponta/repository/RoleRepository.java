package com.junsys.aponta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junsys.aponta.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}