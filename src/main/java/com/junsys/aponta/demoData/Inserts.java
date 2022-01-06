package com.junsys.aponta.demoData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.junsys.aponta.model.Cidade;
import com.junsys.aponta.model.Empresa;
import com.junsys.aponta.model.Role;
import com.junsys.aponta.model.User;
import com.junsys.aponta.repository.EmpresaRepository;
import com.junsys.aponta.repository.RoleRepository;
import com.junsys.aponta.repository.UserRepository;
import com.junsys.aponta.service.CidadeService;



@Component
public class Inserts {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CidadeService cidadeService;
	
	
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		if(roleRepository.count() ==0 ) {
			
			System.out.println("Event: Saving demo data");
			
			Cidade capinzal = new Cidade();
			capinzal = cidadeService.findById((long) 4472);
		
			
			Empresa junSys = new Empresa("JunSys Sistemas", "543547871", "Cliente final", "contato@junsys.com.br", "91.768.605/0001-82", capinzal, "89665-000");
			empresaRepository.save(junSys);		
			
			Role roleAdmin = new Role("ADMIN");
			Role roleUser = new Role("USER");
			
			roleRepository.save(roleAdmin);
			roleRepository.save(roleUser);

			User userAgnaldo = new User("Agnaldo", passwordEncoder.encode("5544690"), roleAdmin, "Agnaldo Junior", "agnaldo88@gmail.com", "49988042847", capinzal, "89665-000", junSys);
			User userUsuario = new User("Usuario", passwordEncoder.encode("1234"), roleUser, "Angelo Silva", "ang_sas@gmail.com", "49988778899", capinzal, "89620-000", junSys);

			userRepository.save(userAgnaldo);
			userRepository.save(userUsuario);

			System.out.println("Demo data saved successfully.");

		}
	}
	
}
