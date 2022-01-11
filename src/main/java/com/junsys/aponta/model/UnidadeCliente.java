package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UnidadeCliente {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Cidade cidade;
	private String cep;
	private String endereco;
	private String cnpj;
	private String razaoSocial;

	public UnidadeCliente(Long id, String nome, Cliente cliente, Cidade cidade, String cep, String endereco,
			String cnpj, String razaoSocial) {
		this.id = id;
		this.nome = nome;
		this.cliente = cliente;
		this.cidade = cidade;
		this.cep = cep;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	
	public UnidadeCliente() {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
