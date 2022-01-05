package com.junsys.aponta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junsys.aponta.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsernameAndDisabled(String username, boolean disabled);
}