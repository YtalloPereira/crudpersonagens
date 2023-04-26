package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.List;
import java.util.Map;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Entry;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.EntryDTO;
import br.edu.ifpb.dac.crudpersonagens.presentation.dto.UserDTO;

public interface ConverterService {

	Entry dtoToEntry(EntryDTO dto);
	
	EntryDTO entryToDTO(Entry entity);

	List<EntryDTO> entryToDTO(List<Entry> entities);
	
	List<Entry> dtoToEntry(List<EntryDTO> dtos);

	List<UserDTO> systemUserToDTO(List<User> entities);
	
	User dtoToSystemUser(UserDTO dto);
	
	UserDTO systemUserToDTO(User entity);
	
	String mapToJson(Map<String, String> map);

	User jsonToUser(String json);

	String jsonToToken(String json);
	
}