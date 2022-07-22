package com.soft.quality.if_yes_if_no_teste.domais;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



@Entity
public class Sprint implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Length(min = 3, max = 200, message = "O campo Título deve ter entre 3 e 200 caracteres.")
	private String descricao;
	
	//Uma sprint pode ter uma ou mais histórias
	@OneToMany(mappedBy = "sprint")
	private List<Historia> historia = new ArrayList<>();
 

	public Sprint() {
		super();
	}

	public Sprint(Integer id,String titulo, Date dataInicio, Date dataFim, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
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


	public void setDescricão(String descricao) {
		this.descricao = descricao;
	}


	public List<Historia> getHistoria() {
		return historia;
	}


	public void setHistoria(List<Historia> historia) {
		this.historia = historia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sprint other = (Sprint) obj;
		return Objects.equals(id, other.id);
	}

}
