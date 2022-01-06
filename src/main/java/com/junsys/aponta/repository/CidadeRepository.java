package com.junsys.aponta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junsys.aponta.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}