package com.soft.quality.if_yes_if_no_teste.resources;

import java.net.URI;
import java.util.List;

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

import com.soft.quality.if_yes_if_no_teste.domais.Cenario;
import com.soft.quality.if_yes_if_no_teste.services.CenárioService;

@RestController
@RequestMapping("/cenario")
public class CenarioResource {

	@Autowired
	 CenárioService cenarioService; 

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cenario>findById(@PathVariable Integer id){
		Cenario obj = cenarioService.encontraPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cenario>>findAll(){
		List<Cenario> list = cenarioService.encontraTodos();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping
	public ResponseEntity<Cenario> create(@RequestBody Cenario obj){
		obj = cenarioService.criaCenario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	// Cria Histórias
		@PostMapping(value = "/create")
		public ResponseEntity<Cenario> create(@RequestParam(value = "criterio", defaultValue = "0") Integer id_cenario, @RequestBody Cenario obj) {
			Cenario newObj = cenarioService.criaCenarioComCategoria(id_cenario,obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(newObj);
		}
		
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<Cenario>update(@PathVariable Integer id, @RequestBody Cenario obj){
		Cenario newObj = cenarioService.atualizaCenario(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		cenarioService.deletaCenario(id);
		return ResponseEntity.noContent().build();
	}
}
