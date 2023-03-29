package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Personagem;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.PersonagemDTO;

@Service
public class PersonagemConverterService {
	
	public Personagem dtoToPersonagem(PersonagemDTO dto) {
		if (dto != null) {
			Personagem entity = new Personagem();
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setHp(dto.getHp());
			entity.setClasse(dto.getClasse());
			entity.setHabilidades(dto.getHabilidades());
			return entity;
		}
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public PersonagemDTO personagemToDto(Personagem entity) {
		if(entity != null) {
			PersonagemDTO dto = new PersonagemDTO();
			dto.setClasse(entity.getClasse());
			dto.setHabilidades(entity.getHabilidades());
			dto.setHp(entity.getHp());
			dto.setId(entity.getId());
			dto.setNome(entity.getNome());
			dto.setHabilidades(entity.getHabilidades());
			
			return dto;
		}
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<Personagem> dtosToPersonagens(List<PersonagemDTO> dtoList) {

		if (dtoList != null) {
			List<Personagem> entityList = new ArrayList<>();

			Personagem entity = null;

			if (dtoList != null && !dtoList.isEmpty()) {
				for (PersonagemDTO dto : dtoList) {
					entity = dtoToPersonagem(dto);
					entityList.add(entity);
				}
			}

			return entityList;
		}

		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<PersonagemDTO> personagensToDtos(List<Personagem> entityList) {
		if (entityList != null) {
			List<PersonagemDTO> dtoList = new ArrayList<>();
			
			PersonagemDTO dto = null;
			
			if (entityList != null && !entityList.isEmpty()) {
				for (Personagem user: entityList) {
					dto = personagemToDto(user);
					dtoList.add(dto);
				}
			}
			
			return dtoList;
		}
		
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
}
