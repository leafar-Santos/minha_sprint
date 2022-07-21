package com.soft.quality.if_yes_if_no_teste.dtos;

import java.io.Serializable;

import com.soft.quality.if_yes_if_no_teste.domais.Historia;

public class HistoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
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
