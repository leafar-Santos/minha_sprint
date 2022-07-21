package com.soft.quality.if_yes_if_no_teste.dtos;

import java.io.Serializable;
import java.util.Date;

import com.soft.quality.if_yes_if_no_teste.domais.Sprint;

public class SprintDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private Date dataInicio;
	private Date dataFim;
	private String descricao;
	
	
	public SprintDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SprintDTO(Sprint obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.dataInicio = obj.getDataInicio();
		this.dataFim = obj.getDataFim();
		this.descricao = obj.getDescricao();
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


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
