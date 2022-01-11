package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.Empresa;
import com.junsys.aponta.repository.EmpresaRepository;


@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> findAll() {
		return repository.findAll();
	}

	public Empresa findById(Long id) {
		
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public Empresa insert(Empresa obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Empresa update(Empresa obj) {
		Empresa newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Empresa newObj, Empresa obj) {
		newObj.setNome(obj.getNome());
		newObj.setFone(obj.getFone());
		newObj.setDescricao(obj.getDescricao());
		newObj.setEmail(obj.getEmail());
		newObj.setCnpj(obj.getCnpj());
		newObj.setCidade(obj.getCidade());
		newObj.setCep(obj.getCep());
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
