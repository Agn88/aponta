package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.EmpresaEtapa;
import com.junsys.aponta.repository.EmpresaEtapaRepository;


@Service
public class EmpresaEtapaService {

	@Autowired
	private EmpresaEtapaRepository repository;

	public List<EmpresaEtapa> findAll() {
		return repository.findAll();
	}

	public EmpresaEtapa findById(Long id) {
		
		Optional<EmpresaEtapa> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public EmpresaEtapa insert(EmpresaEtapa obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public EmpresaEtapa update(EmpresaEtapa obj) {
		EmpresaEtapa newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(EmpresaEtapa newObj, EmpresaEtapa obj) {
		
		newObj.setNome(obj.getNome());
		newObj.setEmpresa(obj.getEmpresa());
	
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
