package com.kabum.adapter.web;

import java.math.BigDecimal;

public class KabumDto {

	private String chave;
	private BigDecimal valorMaximo;
	private String celular;

	public KabumDto(String chave, BigDecimal valorMaximo, String celular) {
		this.chave = chave;
		this.valorMaximo = valorMaximo;
		this.celular = celular;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
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
		return "KabumDto [chave=" + chave + ", valorMaximo=" + valorMaximo + ", celular=" + celular + "]";
	}

}
