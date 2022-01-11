package com.junsys.aponta.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.Cliente;
import com.junsys.aponta.model.UnidadeCliente;
import com.junsys.aponta.repository.UnidadeClienteRepository;


@Service
public class UnidadeClienteService {

	@Autowired
	private UnidadeClienteRepository repository;

	public List<UnidadeCliente> findAll() {
		return repository.findAll();
	}

	public UnidadeCliente findById(Long id) {
		
		Optional<UnidadeCliente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Name: " , null));
	}
	

	public UnidadeCliente insert(UnidadeCliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public UnidadeCliente update(UnidadeCliente obj) {
		UnidadeCliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(UnidadeCliente newObj, UnidadeCliente obj) {
		
		newObj.setCep(obj.getCep());
		newObj.setCidade(obj.getCidade());
		newObj.setCliente(obj.getCliente());
		newObj.setCnpj(obj.getCnpj());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNome(obj.getNome());
		newObj.setRazaoSocial(obj.getRazaoSocial());

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
