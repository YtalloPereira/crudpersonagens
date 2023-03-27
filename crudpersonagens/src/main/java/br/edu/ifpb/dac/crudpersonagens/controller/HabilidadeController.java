package br.edu.ifpb.dac.crudpersonagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.crudpersonagens.dto.HabilidadeDTO;
import br.edu.ifpb.dac.crudpersonagens.dto.PersonagemDTO;
import br.edu.ifpb.dac.crudpersonagens.model.Habilidade;
import br.edu.ifpb.dac.crudpersonagens.model.Personagem;
import br.edu.ifpb.dac.crudpersonagens.services.HabilidadeConverterService;
import br.edu.ifpb.dac.crudpersonagens.services.HabilidadeService;

@RestController
@RequestMapping("/api/habilidade")
public class HabilidadeController {
	
	@Autowired
	private HabilidadeService habilidadeService;
	@Autowired
	private HabilidadeConverterService habilidadeConverterService;
	
	@PostMapping
	public ResponseEntity create(@RequestBody HabilidadeDTO dto) {
	
		try {
			Habilidade entity = habilidadeConverterService.dtoToHabilidade(dto);
			entity = habilidadeService.create(entity);
			dto = habilidadeConverterService.habilidadeToDto(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id")Long id, @RequestBody HabilidadeDTO dto) {
		try {
			dto.setId(id);
			Habilidade entity = habilidadeConverterService.dtoToHabilidade(dto);
			entity = habilidadeService.update(entity);
			dto = habilidadeConverterService.habilidadeToDto(entity);
			
			return ResponseEntity.ok(dto);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity getAll(){
		List<Habilidade> entityList = habilidadeService.listAll();
		List<HabilidadeDTO> dtoList = habilidadeConverterService.habilidadesToDtos(entityList);
		return ResponseEntity.ok(dtoList);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {
		try {
			habilidadeService.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
