package com.soft.quality.if_yes_if_no_teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.soft.quality.if_yes_if_no_teste.domais.Sprint;
import com.soft.quality.if_yes_if_no_teste.dtos.SprintDTO;
import com.soft.quality.if_yes_if_no_teste.repositories.SprintRepository;
import com.soft.quality.if_yes_if_no_teste.services.exceptions.DadosIntegrityViolationException;
import com.soft.quality.if_yes_if_no_teste.services.exceptions.ObjectNotFoundException;


@Service
public class SprintService {

	@Autowired
	SprintRepository sprintRepository;
	
	
	
	public Sprint encontraSprintPorId(Integer id) {
		Optional<Sprint> obj = sprintRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Sprint não Encontrada! ID: " + id + " Tipo " + Sprint.class.getName()));
	}

	
	public Sprint criaSprint(Sprint obj) {
	obj.setId(null);
	return sprintRepository.save(obj);	
	}

	public Sprint atualizaSprint(Integer id, SprintDTO obj) {		
		Sprint newObj = encontraSprintPorId(id);
		
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataInicio(obj.getDataInicio());
		newObj.setDataFim(obj.getDataFim());
		newObj.setDescricão(obj.getDescricao());
		return sprintRepository.save(newObj);
			
	}

	public void deletaSprint(Integer id) {
		encontraSprintPorId(id);
		 try {
			sprintRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DadosIntegrityViolationException("Sprint não pode ser deletada! Possui Histórias associados!");
		}
	}


	public List<Sprint> encotraTodasSprints() {
		return sprintRepository.findAll();
	}

}
