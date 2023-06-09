package br.edu.ifpb.dac.crudpersonagens.presentation.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.crudpersonagens.business.service.ConverterService;
import br.edu.ifpb.dac.crudpersonagens.business.service.EntryService;
import br.edu.ifpb.dac.crudpersonagens.business.service.UserService;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Entry;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.EntryDTO;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

@RestController
@RequestMapping("/api/entry")
public class EntryController {

	@Autowired
	private ConverterService converterService;
	@Autowired
	private EntryService service;
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody EntryDTO dto) {
		try {			
			Entry entity = converterService.dtoToEntry(dto);
			entity = service.save(entity);
			dto = converterService.entryToDTO(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody EntryDTO dto) {
		try {
			dto.setId(id);
			
			Long userId = Long.parseLong(dto.getUserId());
			User user = userService.findById(userId);
			
			if(user == null) {
				throw new IllegalStateException(String.format("Cound not find any user with id=%l", userId));
			}
			
			Entry entity = converterService.dtoToEntry(dto);
			entity.setUser(user);
			
			entity = service.update(entity);
			dto = converterService.entryToDTO(entity);
			
			return ResponseEntity.ok(dto);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity find(
				@RequestParam(value = "description", required = false) String description,
				@RequestParam(value = "month", required = false) Integer month,
				@RequestParam(value = "year", required = false) Integer year,
				@RequestParam(value = "userId") Long userId
			) {
		try {
			Entry filter = new Entry();
			filter.setDescription(description);
			filter.setMonth(month);
			filter.setYear(year);
			
			User user = userService.findById(userId);
			
			if(user == null) {
				throw new IllegalStateException(String.format("Cound not find any user with id=%l", userId));
			}
			
			filter.setUser(user);
			
			List<Entry> entities = service.find(filter);
			List<EntryDTO> dtos = converterService.entryToDTO(entities);
			
			return ResponseEntity.ok(dtos);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

