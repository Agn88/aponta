package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UnidadeResponsavel {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nome;
	private String email;
	private String telefonel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UnidadeCliente unidadeCliente;

	public UnidadeResponsavel(Long id, String nome, String email, String telefonel, UnidadeCliente unidadeCliente) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefonel = telefonel;
		this.unidadeCliente = unidadeCliente;
	}

	public UnidadeResponsavel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonel() {
		return telefonel;
	}

	public void setTelefonel(String telefonel) {
		this.telefonel = telefonel;
	}

	public UnidadeCliente getUnidadeCliente() {
		return unidadeCliente;
	}

	public void setUnidadeCliente(UnidadeCliente unidadeCliente) {
		this.unidadeCliente = unidadeCliente;
	}

}
