package com.soft.quality.if_yes_if_no_teste.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.soft.quality.if_yes_if_no_teste.domais.Criterio;

public class CriterioDTO {

	private Integer id;
	
	@Length(message = "O campo deve ter entre 3 e 20 caracteres.")
	@NotEmpty
	private String descricao;

	public CriterioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CriterioDTO(Criterio obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
