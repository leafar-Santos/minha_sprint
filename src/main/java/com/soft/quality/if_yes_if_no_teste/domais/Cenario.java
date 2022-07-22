package com.soft.quality.if_yes_if_no_teste.domais;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soft.quality.if_yes_if_no_teste.enums.ResultadoTeste;

@Entity
public class Cenario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//O Cenário de teste está em apenas um criterio de aceite.
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "criterio_id")
	private Criterio criterioAceite;
	
	@NotEmpty(message ="O campo cenario de teste é obrigatório")
	@Length(message = "O campo cenário de teste não pode ser vazio. ", min = 1, max = 1000)
	private String cenarioTeste;
	private String preCondicoes;
	private String massaDados;
	private String criteriosEspeciais;
	
	private String ambienteTeste;
	private String ResultadoObtido;
	
	@Enumerated(value = EnumType.STRING)
	private ResultadoTeste resultadoTeste;
	
	private String observacao;
	

	public Cenario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cenario(Integer id, Criterio criterioAceite, String cenarioTeste, String preCondicoes, String massaDados,
			String criteriosEspeciais, String ambienteTeste, String resultadoObtido, ResultadoTeste resultadoTeste,
			String observacao) {
		super();
		this.id = id;
		this.criterioAceite = criterioAceite;
		this.cenarioTeste = cenarioTeste;
		this.preCondicoes = preCondicoes;
		this.massaDados = massaDados;
		this.criteriosEspeciais = criteriosEspeciais;
		this.ambienteTeste = ambienteTeste;
		ResultadoObtido = resultadoObtido;
		this.resultadoTeste = resultadoTeste;
		this.observacao = observacao;
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Criterio getCriterioAceite() {
		return criterioAceite;
	}


	public void setCriterioAceite(Criterio criterioAceite) {
		this.criterioAceite = criterioAceite;
	}


	public String getCenarioTeste() {
		return cenarioTeste;
	}


	public void setCenarioTeste(String cenarioTeste) {
		this.cenarioTeste = cenarioTeste;
	}


	public String getPreCondicoes() {
		return preCondicoes;
	}


	public void setPreCondicoes(String preCondicoes) {
		this.preCondicoes = preCondicoes;
	}


	public String getMassaDados() {
		return massaDados;
	}


	public void setMassaDados(String massaDados) {
		this.massaDados = massaDados;
	}


	public String getCriteriosEspeciais() {
		return criteriosEspeciais;
	}


	public void setCriteriosEspeciais(String criteriosEspeciais) {
		this.criteriosEspeciais = criteriosEspeciais;
	}


	public String getAmbienteTeste() {
		return ambienteTeste;
	}


	public void setAmbienteTeste(String ambienteTeste) {
		this.ambienteTeste = ambienteTeste;
	}


	public String getResultadoObtido() {
		return ResultadoObtido;
	}


	public void setResultadoObtido(String resultadoObtido) {
		ResultadoObtido = resultadoObtido;
	}


	public ResultadoTeste getResultadoTeste() {
		return resultadoTeste;
	}


	public void setResultadoTeste(ResultadoTeste resultadoTeste) {
		this.resultadoTeste = resultadoTeste;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		Cenario other = (Cenario) obj;
		return Objects.equals(id, other.id);
	}
	
}
