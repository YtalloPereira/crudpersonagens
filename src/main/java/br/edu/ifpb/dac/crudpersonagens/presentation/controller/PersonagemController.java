package br.edu.ifpb.dac.crudpersonagens.presentation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.crudpersonagens.business.service.PersonagemConverterService;
import br.edu.ifpb.dac.crudpersonagens.business.service.PersonagemService;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Personagem;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.PersonagemDTO;


@RestController
@RequestMapping("/api/personagem")
public class PersonagemController {
	
	@Autowired
	private PersonagemService personagemService;
	@Autowired
	private PersonagemConverterService personagemConverterService;
	
	@PostMapping
	public ResponseEntity create(@RequestBody PersonagemDTO dto) {
		try {
			Personagem entity = personagemConverterService.dtoToPersonagem(dto);
			entity = personagemService.create(entity);
			dto = personagemConverterService.personagemToDto(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id")Long id, @RequestBody PersonagemDTO dto) {
		try {
			dto.setId(id);
			Personagem entity = personagemConverterService.dtoToPersonagem(dto);
			entity = personagemService.update(entity);
			dto = personagemConverterService.personagemToDto(entity);
			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity getAll() {
		List<Personagem> entityList = personagemService.listAll();
		List<PersonagemDTO> dtoList = personagemConverterService.personagensToDtos(entityList);
		return ResponseEntity.ok(dtoList);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {
		try {
			personagemService.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
