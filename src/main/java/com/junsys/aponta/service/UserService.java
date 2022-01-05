package com.junsys.aponta.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.junsys.aponta.exception.DataIntegrityException;
import com.junsys.aponta.model.User;
import com.junsys.aponta.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	


	public List<User> findAll() {
		return repository.findAll();
	}

	
	public List<User> findAllOrderEnableDisable() {
		
		ArrayList<User> listaEnables = new ArrayList<User>();
		ArrayList<User> listaDisables = new ArrayList<User>();
		
		
		for (User user : repository.findAll()) {
			
			if(user.isDisabled()) {
				listaDisables.add(user);
			}else {
				listaEnables.add(user);
			}	
	    }
		
		listaEnables.addAll(listaDisables);
		
		return listaEnables;
	}

	
	public User findById(Long id) {
		
		Optional<User> resultUser = repository.findById(id);  //return Optional
		User createdUser = resultUser.get();  //return Empresa
		
		return createdUser;
	}
	
	


	public User insert(User obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(User newObj, User obj) {
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
