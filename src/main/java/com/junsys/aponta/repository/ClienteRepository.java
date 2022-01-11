package com.junsys.aponta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junsys.aponta.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}