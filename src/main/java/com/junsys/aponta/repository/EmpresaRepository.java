package com.junsys.aponta.repository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junsys.aponta.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
