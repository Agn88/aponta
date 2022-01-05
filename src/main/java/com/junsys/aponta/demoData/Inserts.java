package com.junsys.aponta.demoData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.junsys.aponta.model.Role;
import com.junsys.aponta.model.User;
import com.junsys.aponta.repository.RoleRepository;
import com.junsys.aponta.repository.UserRepository;



@Component
public class Inserts {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		if(roleRepository.count() ==0 ) {
			
			System.out.println("Event: Saving demo data");
			
			
			Role roleAdmin = new Role("ADMIN");
			Role roleUser = new Role("USER");
			
			roleRepository.save(roleAdmin);
			roleRepository.save(roleUser);

			User userAgnaldo = new User("Agnaldo", passwordEncoder.encode("5544690"), roleAdmin, "Agnaldo Junior", "agnaldo88@gmail.com", "49988042847", "Capinzal", "SC", "Brasil", "89665-000");
			User userUsuario = new User("Usuario", passwordEncoder.encode("1234"), roleUser, "Angelo Silva", "ang_sas@gmail.com", "49988778899", "Campos Novos", "SC", "Brasil", "89620-000");

			userRepository.save(userAgnaldo);
			userRepository.save(userUsuario);

			System.out.println("Demo data saved successfully.");

		}
	}
	
}
