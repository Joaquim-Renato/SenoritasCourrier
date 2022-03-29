package com.senoritas.Corrier.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//informações de coleta
@Entity
@Table(name = "postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	Tipo de entrega se é comida, documento, entre outros 
	@NotNull
	@Size(min = 5, max = 50 )
	private String tipo;
	
//	(descrição breve do que sera transportado pela biker)
	@NotNull 
	@Size(min = 10, max = 200 ) 
	private String descricao;

	
	@NotNull
	private BigDecimal peso; 
	
	@NotNull
	private BigDecimal tamanho;
	
	@Min(0)
	@NotNull
	private int qtdTransportada;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getTamanho() {
		return tamanho;
	}

	public void setTamanho(BigDecimal tamanho) {
		this.tamanho = tamanho;
	}

	public int getQtdTransportada() {
		return qtdTransportada;
	}

	public void setQtdTransportada(int qtdTransportada) {
		this.qtdTransportada = qtdTransportada;
	};
	

}
