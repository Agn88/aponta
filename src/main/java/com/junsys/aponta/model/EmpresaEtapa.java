package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmpresaEtapa {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Empresa  empresa;
	
	public EmpresaEtapa(Long id, String nome, Empresa empresa) {
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
	}

	public EmpresaEtapa() {
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
