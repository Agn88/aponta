package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.Apontamento;
import com.junsys.aponta.repository.ApontamentoRepository;


@Service
public class ApontamentoService {

	@Autowired
	private ApontamentoRepository repository;

	public List<Apontamento> findAll() {
		return repository.findAll();
	}

	public Apontamento findById(Long id) {
		
		Optional<Apontamento> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public Apontamento insert(Apontamento obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Apontamento update(Apontamento obj) {
		Apontamento newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Apontamento newObj, Apontamento obj) {
		
		newObj.setDataFinal(obj.getDataFinal());
		newObj.setDataInicial(obj.getDataInicial());
		newObj.setEmpresaEtapa(obj.getEmpresaEtapa());
		newObj.setHoraFinal(obj.getHoraFinal());
		newObj.setHoraInicial(obj.getDataInicial());
		newObj.setUnidadeProjeto(obj.getUnidadeProjeto());
		newObj.setUser(obj.getUser());

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
