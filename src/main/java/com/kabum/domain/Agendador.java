package com.kabum.domain;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agendador")
public class Agendador {

	@Id
	private UUID id;
	private String produto;
	private BigDecimal valorMaximo;
	private String celular;

	public Agendador(UUID id, String produto, BigDecimal valorMaximo, String celular) {
		this.id = id;
		this.produto = produto;
		this.valorMaximo = valorMaximo;
		this.celular = celular;
	}

	@SuppressWarnings("unused")
	private Agendador() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "KabumObject [id=" + id + ", produto=" + produto + ", valorMaximo=" + valorMaximo + ", celular="
				+ celular + "]";
	}

}
