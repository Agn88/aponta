package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.UnidadeResponsavel;
import com.junsys.aponta.model.UnidadeProjeto;
import com.junsys.aponta.repository.UnidadeResponsavelRepository;


@Service
public class UnidadeResponsavelService {

	@Autowired
	private UnidadeResponsavelRepository repository;

	public List<UnidadeResponsavel> findAll() {
		return repository.findAll();
	}

	public UnidadeResponsavel findById(Long id) {
		
		Optional<UnidadeResponsavel> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public UnidadeResponsavel insert(UnidadeResponsavel obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public UnidadeResponsavel update(UnidadeResponsavel obj) {
		UnidadeResponsavel newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(UnidadeResponsavel newObj, UnidadeResponsavel obj) {
		
		newObj.setEmail(obj.getEmail());
		newObj.setNome(obj.getNome());
		newObj.setTelefonel(obj.getTelefonel());
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
