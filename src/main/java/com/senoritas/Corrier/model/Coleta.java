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
@Entity // Cria a tabela
@Table(name = "tb_coleta")
public class Coleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	Tipo de entrega se é comida, documento, entre outros 
	@NotNull (message = "O Tipo de entrega é obrigatorio!!")
	@Size(min = 5, max = 50, message = "O atributo tipo deve conter entre 5 e 25 caracteres!! ")
	private String tipo;
	

	@Size(min = 10, max = 200, message = "breve descrição do que sera transportado pela biker! max 200 caracteres" ) 
	private String descricao;

	
	@NotNull (message = "O peso é obrigatorio!! informe quantos kg aprox")
	private BigDecimal peso; 
	
	@NotNull (message = "breve descrição contendo o tamanho/volume que sera transportado! Max 100 caracteres")
	@Size(min = 1, max = 100, message = "quantos CM's aproximadamente?") 
	private String tamanho;
	
	@Min(0)
	@NotNull (message = "A quantidade é relevante!!")
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

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQtdTransportada() {
		return qtdTransportada;
	}

	public void setQtdTransportada(int qtdTransportada) {
		this.qtdTransportada = qtdTransportada;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	
}
