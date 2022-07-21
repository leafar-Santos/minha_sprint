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
public class Criterio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descricao;

	// varios criterios para uma História
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "historia_id")
	private Historia historia;

	// Um Critério de aceite tem um ou mais cenários de teste.
	@OneToMany(mappedBy = "criterioAceite")
	private List<Cenario> cenario = new ArrayList<>();

	public Criterio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criterio(Integer id, String descricao, Historia historia) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.historia = historia;
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

	public List<Cenario> getCenariosTeste() {
		return cenario;
	}

	public void setCenariosTeste(List<Cenario> cenario) {
		this.cenario = cenario;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia histpria) {
		this.historia = histpria;
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
		Criterio other = (Criterio) obj;
		return Objects.equals(id, other.id);
	}

}
