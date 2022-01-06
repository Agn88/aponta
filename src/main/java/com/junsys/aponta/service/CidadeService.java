package com.junsys.aponta.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.Cidade;
import com.junsys.aponta.repository.CidadeRepository;



@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	


	public List<Cidade> findAll() {
		return repository.findAll();
	}

	
	

	
	public Cidade findById(Long id) {
		
		Optional<Cidade> resultCidade = repository.findById(id);  //return Optional
		Cidade createdCidade = resultCidade.get();  //return Cidade
		
		return createdCidade;
	}
	
	


	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Cidade update(Cidade obj) {
		Cidade newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Cidade newObj, Cidade obj) {
		/*
		newObj.setNome(obj.getNome());
		newObj.setFone(obj.getFone());
		newObj.setDescricao(obj.getDescricao());
		newObj.setEmail(obj.getEmail());
		newObj.setCnpj(obj.getCnpj());
		newObj.setCidade(obj.getCidade());
		newObj.setEstado(obj.getEstado());
		newObj.setPais(obj.getPais());
		newObj.setCep(obj.getCep());
		*/
	}

	/*
	 * public Picador fromDTO(Picador objDto) { return new Picador(objDto.getId(),
	 * objDto.getNome(), objDto.getIp(), objDto.getNumeroSerie(),
	 * objDto.getCidade(), objDto.getEstado(), objDto.getPais(),
	 * Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"),
	 * Instant.parse("2019-06-20T19:53:07Z") ); }
	 */
	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not possible delete to Machine!");
		}

	}
}
