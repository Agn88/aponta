package com.junsys.aponta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junsys.aponta.model.UnidadeCliente;

public interface UnidadeClienteRepository extends JpaRepository<UnidadeCliente, Long> {
}