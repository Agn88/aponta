package com.junsys.aponta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmpresaEtapaConf {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private EmpresaEtapa empresaEtapa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UnidadeProjeto unidadeProjeto;
	
	private float horasOrcadas;

	public EmpresaEtapaConf(Long id, EmpresaEtapa empresaEtapa, UnidadeProjeto unidadeProjeto,
			float horasOrcadas) {
		this.id = id;
		this.empresaEtapa = empresaEtapa;
		this.unidadeProjeto = unidadeProjeto;
		this.horasOrcadas = horasOrcadas;
	}

	public EmpresaEtapaConf() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmpresaEtapa getEmpresaEtapa() {
		return empresaEtapa;
	}

	public void setEmpresaEtapa(EmpresaEtapa empresaEtapa) {
		this.empresaEtapa = empresaEtapa;
	}

	public UnidadeProjeto getUnidadeProjeto() {
		return unidadeProjeto;
	}

	public void setUnidadeProjeto(UnidadeProjeto unidadeProjeto) {
		this.unidadeProjeto = unidadeProjeto;
	}

	public float getHorasOrcadas() {
		return horasOrcadas;
	}

	public void setHorasOrcadas(float horasOrcadas) {
		this.horasOrcadas = horasOrcadas;
	}
	
	
	

}
