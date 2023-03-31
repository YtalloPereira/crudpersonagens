package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Personagem;
import br.edu.ifpb.dac.crudpersonagens.model.repository.PersonagemRepository;


@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepository personagemDAO;
	
	public Personagem create(Personagem novoPersonagem) {
		return personagemDAO.save(novoPersonagem);
	}
	
	public Personagem update(Personagem personagemAtualizado) {
		return personagemDAO.save(personagemAtualizado);
	}
	
	public List<Personagem> listAll(){
		return personagemDAO.findAll();
	}
	
//	public List<Personagem> find(Personagem filter){
//		Example example = Example.of(filter,
//				ExampleMatcher.matching()
//				.withIgnoreCase()
//				.withStringMatcher(StringMatcher.CONTAINING));
//		
//		return personagemDAO.findAll(example);
//	}
	
	
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
