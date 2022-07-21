package com.soft.quality.if_yes_if_no_teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.soft.quality.if_yes_if_no_teste.domais.Criterio;
import com.soft.quality.if_yes_if_no_teste.domais.Historia;
import com.soft.quality.if_yes_if_no_teste.repositories.CriterioRepository;
import com.soft.quality.if_yes_if_no_teste.services.exceptions.ObjectNotFoundException;

@Service
public class CriterioService {

	@Autowired
	CriterioRepository criterioRepository;
	
	@Autowired
	HistoriaService historiaService;
	
	public Criterio encontraCriterioPorId(Integer id) {
		Optional<Criterio> obj = criterioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Criterio de Aceite não Encontrado! ID: " + id + " Tipo " + Criterio.class.getName()));
	}

	
	//Lista todos sem cenários
	public List<Criterio> encontraTodosSemCenario() {
		return criterioRepository.findAll();
	}


	public Criterio criaCriterioComHIstoria(Integer id_historia, Criterio obj) {
		obj.setId(null);
		Historia historia = historiaService.encontraHistoriaPorId(id_historia);
		obj.setHistoria(historia);
		return criterioRepository.save(obj);
	}


	public Criterio atualizaCriterio(Integer id, Criterio obj) {
		Criterio newObj = encontraCriterioPorId(id);
		newObj.setDescricao(obj.getDescricao());
		return criterioRepository.save(newObj);
	}


	public void apagaCriterio(Integer id) {
		encontraCriterioPorId(id);	
		try {
			criterioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ObjectNotFoundException("Criterio de aceite não pode ser apagado pois possui cenários de testes cadastrados!");
		}
	
	}
	
	
	
}
