package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UnidadeProjeto {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UnidadeCliente unidadeCliente;

	public UnidadeProjeto(Long id, String descricao, UnidadeCliente unidadeCliente) {
		this.id = id;
		this.descricao = descricao;
		this.unidadeCliente = unidadeCliente;
	}

	public UnidadeProjeto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UnidadeCliente getUnidadeCliente() {
		return unidadeCliente;
	}

	public void setUnidadeCliente(UnidadeCliente unidadeCliente) {
		this.unidadeCliente = unidadeCliente;
	}

	

}
