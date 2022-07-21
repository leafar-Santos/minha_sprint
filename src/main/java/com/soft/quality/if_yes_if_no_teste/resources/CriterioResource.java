package com.soft.quality.if_yes_if_no_teste.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.soft.quality.if_yes_if_no_teste.domais.Criterio;
import com.soft.quality.if_yes_if_no_teste.dtos.CriterioDTO;
import com.soft.quality.if_yes_if_no_teste.services.CriterioService;

@RestController
@RequestMapping("/criterio")
public class CriterioResource {

	@Autowired
	CriterioService criterioService;
	
	//Busca criterios com todos os dados dos cenários
	@GetMapping(value = "/{id}")
	public ResponseEntity<Criterio>findById(@PathVariable Integer id){
		Criterio obj =  criterioService.encontraCriterioPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Busca Apenas o critério por id
	@GetMapping(value = "/ctr/{id}")
	public ResponseEntity<CriterioDTO>encontraCriterioPorId(@PathVariable Integer id){
		
		Criterio criterio = criterioService.encontraCriterioPorId(id);
		CriterioDTO criterioDTO = new CriterioDTO(criterio);
		return ResponseEntity.ok().body(criterioDTO);
			
	}
	

	//BUsca todas as histórias sem retornar os critérios
	@GetMapping
	public ResponseEntity <List<CriterioDTO>>findAll(){
		List <Criterio> list = criterioService.encontraTodosSemCenario();
		List <CriterioDTO>listDTO = list.stream().map(obj -> new CriterioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
				
	}
	
	@PostMapping
	public ResponseEntity<Criterio> create(@RequestParam(value = "historia", defaultValue = "0")Integer id_historia,@RequestBody Criterio obj){
		Criterio newObj = criterioService.criaCriterioComHIstoria(id_historia, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	// Atualiza O criterio
	@PutMapping(value = "/{id}")
	public ResponseEntity<Criterio>atualizaCriterio(@PathVariable Integer id, @RequestBody Criterio obj){
		Criterio newObj = criterioService.atualizaCriterio(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	//Deleta Criterio
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		criterioService.apagaCriterio(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
