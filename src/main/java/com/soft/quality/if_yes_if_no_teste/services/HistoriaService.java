package com.soft.quality.if_yes_if_no_teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.soft.quality.if_yes_if_no_teste.domais.Historia;
import com.soft.quality.if_yes_if_no_teste.domais.Sprint;
import com.soft.quality.if_yes_if_no_teste.repositories.HistoriaRepository;
import com.soft.quality.if_yes_if_no_teste.services.exceptions.ObjectNotFoundException;

@Service
public class HistoriaService {

	@Autowired
	HistoriaRepository historiaRepository;
	
	@Autowired
	SprintService sprinService;
	
	public Historia encontraHistoriaPorId(Integer id) {
		Optional<Historia> obj = historiaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Historia não Encontrada! ID: " + id + " Tipo " + Historia.class.getName()));
	}

	public Historia criaHistoria(Historia obj) {
		obj.setId(null);
		return historiaRepository.save(obj);
		
	}
	
	
	public Historia criaHistoriaComCategoria(Integer id_sprint, Historia obj) {
		obj.setId(null);
		Sprint sprint = sprinService.encontraSprintPorId(id_sprint);
		obj.setSprint(sprint);
		return historiaRepository.save(obj);
		
	}
	
	public List<Historia> encontraTodasSemCriterios() {
		return historiaRepository.findAll();
	}

	public Historia atualizaHistoria(Integer id, Historia obj) {
		Historia newObj = encontraHistoriaPorId(id);
		newObj.setTitulo(obj.getTitulo());
		return historiaRepository.save(newObj);
	}

	
	
	public void apagaHistoria(Integer id) {
		encontraHistoriaPorId(id);
		try {
			historiaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ObjectNotFoundException("História não pode ser apagada pois possui cenários de testes cadastrados!");
		}
		
	}


}
