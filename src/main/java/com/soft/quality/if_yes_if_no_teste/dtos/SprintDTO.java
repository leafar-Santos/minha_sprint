package com.soft.quality.if_yes_if_no_teste.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.soft.quality.if_yes_if_no_teste.domais.Sprint;

public class SprintDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo Títilo é obrigatório")
	@Length(min = 3, max = 20, message = "O campo Título deve ter entre 3 e 20 caracteres.")
	private String titulo;
	
	@NotNull(message = "O campo dataInicio é obrigatório")
	//@Future(message = "A data de início da Sprint deve ser maior ou igual a data atual")
	private Date dataInicio;
	
	@NotNull(message = "O campo dataFim é obrigatório")
	//@Future(message = "A data de término da Sprint deve ser maior ou igual a data atual")
	private Date dataFim;
	

	@Length(min = 3, max = 200, message = "O campo Descrição deve ter entre 3 e 200 caracteres.")
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
