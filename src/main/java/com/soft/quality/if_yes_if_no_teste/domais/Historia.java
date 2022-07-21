package com.soft.quality.if_yes_if_no_teste.domais;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Historia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	
	//Uma sprint pode ter varias histórias
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;
	
	//Uma Históra pode ter um ou mais critérios de aceite
	@OneToMany(mappedBy = "historia")
	private List<Criterio> criterioAceite = new ArrayList<>();

	public Historia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Historia(Integer id, String titulo, Sprint sprint) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sprint = sprint;
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

	public List<Criterio> getCriterioAceite() {
		return criterioAceite;
	}

	public void setCriterioAceite(List<Criterio> criterioAceite) {
		this.criterioAceite = criterioAceite;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
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
		Historia other = (Historia) obj;
		return Objects.equals(id, other.id);
	}
	

}
