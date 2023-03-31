package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Habilidade;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.HabilidadeDTO;

@Service
public class HabilidadeConverterService {
	
	 public Habilidade dtoToHabilidade(HabilidadeDTO dto) {
		if (dto != null) {
			Habilidade entity = new Habilidade();
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setCooldown(dto.getCooldown());
			entity.setDano(dto.getDano());
			entity.setDescricao(dto.getDescricao());
		
			return entity;
		}
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public HabilidadeDTO habilidadeToDto(Habilidade entity) {
		if(entity != null) {
			HabilidadeDTO dto = new HabilidadeDTO();
			dto.setId(entity.getId());
			dto.setNome(entity.getNome());
			dto.setCooldown(entity.getCooldown());
			dto.setDano(entity.getDano());
			dto.setDescricao(entity.getDescricao());
			dto.setPersonagemId(entity.getPersonagem().getId());
			
			return dto;
		}
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<Habilidade> dtosToHabilidades(List<HabilidadeDTO> dtoList) {

		if (dtoList != null) {
			List<Habilidade> entityList = new ArrayList<>();

			Habilidade entity = null;

			if (dtoList != null && !dtoList.isEmpty()) {
				for (HabilidadeDTO dto : dtoList) {
					entity = dtoToHabilidade(dto);
					entityList.add(entity);
				}
			}

			return entityList;
		}

		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
	
	public List<HabilidadeDTO> habilidadesToDtos(List<Habilidade> entityList) {
		if (entityList != null) {
			List<HabilidadeDTO> dtoList = new ArrayList<>();
			
			HabilidadeDTO dto = null;
			
			if (entityList != null && !entityList.isEmpty()) {
				for (Habilidade user: entityList) {
					dto = habilidadeToDto(user);
					dtoList.add(dto);
				}
			}
			
			return dtoList;
		}
		
		throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
	}
}
