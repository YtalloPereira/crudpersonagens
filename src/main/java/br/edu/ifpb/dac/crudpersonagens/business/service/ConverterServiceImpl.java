package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Entry;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Role;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;
import br.edu.ifpb.dac.crudpersonagens.model.enums.EntryStatus;
import br.edu.ifpb.dac.crudpersonagens.model.enums.EntryType;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.EntryDTO;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.UserDTO;

@Service
public class ConverterServiceImpl implements ConverterService{

	@Override
	public Entry dtoToEntry(EntryDTO dto) {
		Entry entity = new Entry();
		
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setMonth(dto.getMonth());
		entity.setYear(dto.getYear());
		entity.setValue(dto.getValue());
		
		if(dto.getType() != null) {
			EntryType type = EntryType.valueOf(dto.getType());
			entity.setType(type);
		}
		
		if(dto.getStatus() != null) {
			EntryStatus status = EntryStatus.valueOf(dto.getStatus());
			entity.setStatus(status);
		}
		
		return entity;
	}

	@Override
	public EntryDTO entryToDTO(Entry entity) {
		EntryDTO dto = new EntryDTO();
		
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setMonth(entity.getMonth());
		dto.setYear(entity.getYear());
		dto.setValue(entity.getValue());
		dto.setType(entity.getType().toString());
		dto.setStatus(entity.getStatus().toString());
		dto.setUserId(entity.getUser().getId().toString());
		
		return dto;
	}

	@Override
	public List<EntryDTO> entryToDTO(List<Entry> entities) {
		List<EntryDTO> dtos = new ArrayList<>();
		
		for (Entry entry : entities) {
			EntryDTO dto = entryToDTO(entry);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public List<Entry> dtoToEntry(List<EntryDTO> dtos) {
		List<Entry> entities = new ArrayList<>();
		
		for (EntryDTO dto : dtos) {
			Entry entity = dtoToEntry(dto);
			entities.add(entity);
		}
		
		return entities;
	}

	@Override
	public List<UserDTO> systemUserToDTO(List<User> entities) {
		List<UserDTO> dtos = new ArrayList<>();
		
		for (User dto : entities) {
			UserDTO entity = systemUserToDTO(dto);
			dtos.add(entity);
		}
		
		return dtos;
	}

	@Override
	public User dtoToSystemUser(UserDTO dto) {
		User entity = new User();
		
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());
		
		return entity;
	}

	@Override
	public UserDTO systemUserToDTO(User entity) {
		UserDTO dto = new UserDTO();
		
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		
		List<String> roles = new ArrayList<>();
		if(entity.getRoles() != null) {
			for (Role role : entity.getRoles()) {
				roles.add(role.getNome());
			}
		}
		
		dto.setRoles(roles.toArray(new String[0]));
		
		return dto;
	}

	@Override
	public String mapToJson(Map<String, String> map) {
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}

	@Override
	public User jsonToUser(String json) {
		JsonElement jsonElement = JsonParser.parseString(json);
		JsonObject results = jsonElement.getAsJsonObject()
										.get("results")
										.getAsJsonArray()
										.get(0)
										.getAsJsonObject();
		
		String name = results.get("nome").getAsString();
		User user = new User();
		user.setNome(name);
		
		return user;
	}

	@Override
	public String jsonToToken(String json) {
		JsonElement jsonElement = JsonParser.parseString(json);
		String token = jsonElement.getAsJsonObject().get("token").getAsString();
		return token;
	}

}
