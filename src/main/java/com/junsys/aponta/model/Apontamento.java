package com.junsys.aponta.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Apontamento {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UnidadeProjeto unidadeProjeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private EmpresaEtapa empresaEtapa;

	// data em timezone GMT
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'", timezone = "GMT")
	private Instant dataInicial;

	// data em timezone GMT
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'", timezone = "GMT")
	private Instant dataFinal;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "GMT")
	private Instant horaInicial;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "GMT")
	private Instant horaFinal;

	public Apontamento(Long id, User user, UnidadeProjeto unidadeProjeto, EmpresaEtapa empresaEtapa,
			Instant dataInicial, Instant dataFinal, Instant horaInicial, Instant horaFinal) {
		this.id = id;
		this.user = user;
		this.unidadeProjeto = unidadeProjeto;
		this.empresaEtapa = empresaEtapa;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}

	public Apontamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UnidadeProjeto getUnidadeProjeto() {
		return unidadeProjeto;
	}

	public void setUnidadeProjeto(UnidadeProjeto unidadeProjeto) {
		this.unidadeProjeto = unidadeProjeto;
	}

	public EmpresaEtapa getEmpresaEtapa() {
		return empresaEtapa;
	}

	public void setEmpresaEtapa(EmpresaEtapa empresaEtapa) {
		this.empresaEtapa = empresaEtapa;
	}

	public Instant getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Instant dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Instant getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Instant dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Instant getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Instant horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Instant getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Instant horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	

}
