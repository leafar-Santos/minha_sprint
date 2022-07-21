package com.soft.quality.if_yes_if_no_teste.dtos;

import com.soft.quality.if_yes_if_no_teste.domais.Criterio;

public class CriterioDTO {

	private Integer id;
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
