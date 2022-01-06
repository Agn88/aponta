package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String nome;
	
	private String nome_pt; 
	
	private String sigla;
	
	private int bacen;
	
	

	public Pais() {
	}

	public Pais(Long id, String nome, String nome_pt, String sigla, int bacen) {
		this.id = id;
		this.nome = nome;
		this.nome_pt = nome_pt;
		this.sigla = sigla;
		this.bacen = bacen;
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

	public String getNome_pt() {
		return nome_pt;
	}

	public void setNome_pt(String nome_pt) {
		this.nome_pt = nome_pt;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getBacen() {
		return bacen;
	}

	public void setBacen(int bacen) {
		this.bacen = bacen;
	}
	
	
	
	
	
}
