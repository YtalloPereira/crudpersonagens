package br.edu.ifpb.dac.crudpersonagens.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.dao.PersonagemDAO;
import br.edu.ifpb.dac.crudpersonagens.model.Personagem;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemDAO personagemDAO;
	
	public void create(Personagem novoPersonagem) {
		personagemDAO.save(novoPersonagem);
	}
	
	public void update(Personagem personagemAtualizado) {
		personagemDAO.save(personagemAtualizado);
	}
	
	public List<Personagem> listAll(){
		return personagemDAO.findAll();
	}
	
	public Personagem getById(Long id) {
		return personagemDAO.getReferenceById(id);
	}
	
	public void deleteAll() {
		personagemDAO.deleteAll();
	}
	
	public void deleteById(Long id) {
		personagemDAO.deleteById(id);
	}
}
