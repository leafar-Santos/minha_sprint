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

import com.soft.quality.if_yes_if_no_teste.domais.Historia;
import com.soft.quality.if_yes_if_no_teste.dtos.HistoriaDTO;
import com.soft.quality.if_yes_if_no_teste.services.HistoriaService;

@RestController
@RequestMapping("/historia")
public class HistoriaResource {

	@Autowired
	HistoriaService historiaService;

	// Busca Histórias por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Historia> finById(@PathVariable Integer id) {

		Historia obj = historiaService.encontraHistoriaPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	// Busca todas as histórias sem a sprint e sem os cenários
	@GetMapping()
	public ResponseEntity<List<HistoriaDTO>> findAll() {
		List<Historia> list = historiaService.encontraTodasSemCriterios();
		List<HistoriaDTO> listDTO = list.stream().map(obj -> new HistoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// Busca Apenas uma Historia sem cenários por id
	@GetMapping(value = "/ht/{id}")
	public ResponseEntity<HistoriaDTO> findHistoriaById(@PathVariable Integer id) {
		Historia historia = historiaService.encontraHistoriaPorId(id);
		HistoriaDTO historiaDTO = new HistoriaDTO(historia);
		return ResponseEntity.ok().body(historiaDTO);
	}

	// Cria Histórias
	@PostMapping
	public ResponseEntity<Historia> create(@RequestParam(value = "sprint", defaultValue = "0") Integer id_sprint, @RequestBody Historia obj) {
		Historia newObj = historiaService.criaHistoriaComCategoria(id_sprint,obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	
	// Atualiza a história
	@PutMapping(value = "/{id}")
	public ResponseEntity<Historia>atualizaHistoria(@PathVariable Integer id, @RequestBody Historia obj){
		Historia newObj = historiaService.atualizaHistoria(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	///Deleta por id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		historiaService.apagaHistoria(id);
		return ResponseEntity.noContent().build();
	}
	
}
