package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.UnidadeCliente;
import com.junsys.aponta.model.UnidadeProjeto;
import com.junsys.aponta.repository.UnidadeProjetoRepository;


@Service
public class UnidadeProjetoService {

	@Autowired
	private UnidadeProjetoRepository repository;

	public List<UnidadeProjeto> findAll() {
		return repository.findAll();
	}

	public UnidadeProjeto findById(Long id) {
		
		Optional<UnidadeProjeto> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public UnidadeProjeto insert(UnidadeProjeto obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public UnidadeProjeto update(UnidadeProjeto obj) {
		UnidadeProjeto newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(UnidadeProjeto newObj, UnidadeProjeto obj) {
		
		newObj.setDescricao(obj.getDescricao());
		newObj.setUnidadeCliente(obj.getUnidadeCliente());
		
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
