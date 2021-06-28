package com.kabum.adapter.http;

import java.math.BigDecimal;

public class KabumResources {

	private String nomeDaPlaca;
	private Boolean disponibilidade;
	private BigDecimal precoVista;
	private String link;

	public KabumResources(String nomeDaPlaca, Boolean disponibilidade, BigDecimal precoVista, String link) {
		this.nomeDaPlaca = nomeDaPlaca;
		this.disponibilidade = disponibilidade;
		this.precoVista = precoVista;
		this.link = link;
	}

	public String getNomeDaPlaca() {
		return nomeDaPlaca;
	}

	public void setNomeDaPlaca(String nomeDaPlaca) {
		this.nomeDaPlaca = nomeDaPlaca;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public BigDecimal getPrecoVista() {
		return precoVista;
	}

	public void setPrecoVista(BigDecimal precoVista) {
		this.precoVista = precoVista;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "KabumResources [nomeDaPlaca=" + nomeDaPlaca + ", disponibilidade=" + disponibilidade + ", precoVista="
				+ precoVista + ", link=" + link + "]";
	}

}
