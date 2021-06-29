package com.kabum.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Registro")
public class Registro {

	@Id
	private UUID id;
	private String produto;
	private BigDecimal valor;
	private String link;
	private LocalDateTime data;

	public Registro(UUID id, String produto, BigDecimal valor, String link, LocalDateTime data) {
		this.id = id;
		this.produto = produto;
		this.valor = valor;
		this.link = link;
		this.data = data;
	}

	@SuppressWarnings("unused")
	private Registro() {
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", produto=" + produto + ", valor=" + valor + ", link=" + link + ", data=" + data
				+ "]";
	}

}
