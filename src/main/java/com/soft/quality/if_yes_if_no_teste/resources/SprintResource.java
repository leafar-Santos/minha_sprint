package com.soft.quality.if_yes_if_no_teste.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.soft.quality.if_yes_if_no_teste.domais.Sprint;
import com.soft.quality.if_yes_if_no_teste.dtos.SprintDTO;
import com.soft.quality.if_yes_if_no_teste.services.SprintService;


@RestController
@RequestMapping(value="/sprints")
public class SprintResource {
	
	@Autowired
	SprintService sprintService;
	
	//Busca Sprints por id com todos os dados
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sprint> findById(@PathVariable Integer id){
		Sprint obj = sprintService.encontraSprintPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Busca Apenas uma sprint por id 	
	@GetMapping(value = "/spt/{id}")
	public ResponseEntity<SprintDTO> findSprintById(@PathVariable Integer id){
		Sprint sprint = sprintService.encontraSprintPorId(id);
		SprintDTO sprintDTO = new SprintDTO(sprint);
		return ResponseEntity.ok().body(sprintDTO);
	}
	
	
	//Retorna Apenas as sprints sem os dados das histórias
	@GetMapping
	public ResponseEntity<List<SprintDTO>>findAll(){
		List <Sprint>list = sprintService.encotraTodasSprints();
		List<SprintDTO>listDTO = list.stream().map(obj -> new SprintDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//Método para criar Sprint
	@PostMapping
	public ResponseEntity<Sprint>create(@Valid @RequestBody Sprint obj){
		obj = sprintService.criaSprint(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//Atualza a Sprint
	@PutMapping(value ="/{id}")
	public ResponseEntity<Sprint>update(@Valid @PathVariable Integer id, @RequestBody SprintDTO obj){
		sprintService.atualizaSprint(id, obj);
		return ResponseEntity.ok().build();
		//Sprint newObj = sprintService.atualizaSprint(id, obj);
		//return ResponseEntity.ok().body(newObj);
	}
	
	//Deleta a Sprint
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		sprintService.deletaSprint(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
