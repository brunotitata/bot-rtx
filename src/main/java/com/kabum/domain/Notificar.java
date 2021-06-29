package com.kabum.domain;

import java.math.BigDecimal;

public class Notificar {

	private String celular;
	private String msg;
	private String produto;
	private BigDecimal valor;
	private String link;

	public Notificar(String celular, String msg, String produto, BigDecimal valor, String link) {
		this.celular = celular;
		this.msg = msg;
		this.produto = produto;
		this.valor = valor;
		this.link = link;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	@Override
	public String toString() {
		return "Notificar [celular=" + celular + ", msg=" + msg + ", produto=" + produto + ", valor=" + valor
				+ ", link=" + link + "]";
	}

}
