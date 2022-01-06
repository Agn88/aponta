package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Empresa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String fone;
	private String descricao;
	private String email;
	private String cnpj;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	

	public Empresa(String nome, String fone, String descricao, String email, String cnpj, String cidade,
			String estado, String pais, String cep) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.descricao = descricao;
		this.email = email;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	
	
	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public Empresa() {
		super();
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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
