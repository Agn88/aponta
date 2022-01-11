package com.junsys.aponta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junsys.aponta.model.Apontamento;

public interface ApontamentoRepository extends JpaRepository<Apontamento, Long> {
}