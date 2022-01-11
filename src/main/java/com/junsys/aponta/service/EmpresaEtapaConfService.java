package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.EmpresaEtapaConf;
import com.junsys.aponta.repository.EmpresaEtapaConfRepository;


@Service
public class EmpresaEtapaConfService {

	@Autowired
	private EmpresaEtapaConfRepository repository;

	public List<EmpresaEtapaConf> findAll() {
		return repository.findAll();
	}

	public EmpresaEtapaConf findById(Long id) {
		
		Optional<EmpresaEtapaConf> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public EmpresaEtapaConf insert(EmpresaEtapaConf obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public EmpresaEtapaConf update(EmpresaEtapaConf obj) {
		EmpresaEtapaConf newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(EmpresaEtapaConf newObj, EmpresaEtapaConf obj) {
				
		newObj.setEmpresaEtapa(obj.getEmpresaEtapa());
		newObj.setHorasOrcadas(obj.getHorasOrcadas());
		newObj.setUnidadeProjeto(obj.getUnidadeProjeto());
	
	}


	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not possible delete to Machine!");
		}

	}
}
