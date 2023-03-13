package br.edu.ifpb.dac.crudpersonagens.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.crudpersonagens.model.Habilidade;
import br.edu.ifpb.dac.crudpersonagens.model.Personagem;
import br.edu.ifpb.dac.crudpersonagens.services.PersonagemService;

@Controller
public class PersonagemController {
	
	@Autowired
	private PersonagemService personagemService;
	
	public void create(String nome, String classe, int hp, List<Habilidade> habilidades) {
		Personagem novoPersonagem = new Personagem(nome, classe, hp, habilidades);
		personagemService.create(novoPersonagem);
	}
	
	public void update(Personagem personagemAtualizado) {
		personagemService.update(personagemAtualizado);
	}
	
	public List<Personagem> listAll(){
		return personagemService.listAll();
	}
	
	public Personagem getById(Long id) {
		return personagemService.getById(id);
	}
	
	public void deleteAll() {
		personagemService.deleteAll();
	}
	
	public void deleteById(Long id) {
		personagemService.deleteById(id);
	}
	
}
