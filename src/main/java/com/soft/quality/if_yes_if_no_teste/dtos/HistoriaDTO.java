package com.soft.quality.if_yes_if_no_teste.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.soft.quality.if_yes_if_no_teste.domais.Historia;

public class HistoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "O campo Título é Obrigatório ")
	@Length(message = "O campo deve ter entre 3 e 20 caracteres.")
	private String titulo;

	public HistoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoriaDTO(Historia obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
