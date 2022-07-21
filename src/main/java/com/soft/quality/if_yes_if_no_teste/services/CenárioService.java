package com.soft.quality.if_yes_if_no_teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.quality.if_yes_if_no_teste.domais.Cenario;
import com.soft.quality.if_yes_if_no_teste.domais.Criterio;
import com.soft.quality.if_yes_if_no_teste.repositories.CenarioRepository;
import com.soft.quality.if_yes_if_no_teste.services.exceptions.ObjectNotFoundException;


@Service
public class CenárioService {

	@Autowired
	CenarioRepository cenarioRepository;
	
	@Autowired
	CriterioService criterioService;
	
	public Cenario encontraPorId(Integer id) {
		Optional<Cenario> obj = cenarioRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Cenário de Teste não econtrado ID: " + id + " Tipo " + Cenario.class.getName()));
		
	}

	public Cenario criaCenario(Cenario obj) {
		obj.setId(null);
		return cenarioRepository.save(obj);
	}

	
	public Cenario criaCenarioComCategoria(Integer id_cenario, Cenario obj) {
		obj.setId(null);
		Criterio criterio = criterioService.encontraCriterioPorId(id_cenario);
		obj.setCriterioAceite(criterio);
		return cenarioRepository.save(obj);
	}
		
	
	public Cenario atualizaCenario(Integer id, Cenario obj) {
		Cenario newObj = encontraPorId(id);
		newObj.setCenarioTeste(obj.getCenarioTeste());
		newObj.setPreCondicoes(obj.getPreCondicoes());
		newObj.setMassaDados(obj.getMassaDados());
		newObj.setCriteriosEspeciais(obj.getCriteriosEspeciais());
		newObj.setAmbienteTeste(obj.getAmbienteTeste());
		newObj.setResultadoTeste(obj.getResultadoTeste());
		newObj.setObservacao(obj.getObservacao());
		newObj.setResultadoObtido(obj.getResultadoObtido());
		return cenarioRepository.save(newObj);
	}

	
	public void deletaCenario(Integer id) {
		encontraPorId(id);
		
		try {
		cenarioRepository.deleteById(id);
		}
		catch(ObjectNotFoundException e){
			throw new ObjectNotFoundException("Objeto não econtrado!");
		}
	}

	public List<Cenario> encontraTodos() {
		
		return cenarioRepository.findAll();
		
		
	}


	

		
}
