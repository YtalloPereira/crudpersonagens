package br.edu.ifpb.dac.crudpersonagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifpb.dac.crudpersonagens.model.Habilidade;
import br.edu.ifpb.dac.crudpersonagens.services.HabilidadeService;

@Controller
public class HabilidadeController {
	
	@Autowired
	private HabilidadeService habilidadeService;
	
	public void create(String nome, int cooldown, String descricao, int dano) {
		Habilidade novaHabilidade = new Habilidade(nome, cooldown, descricao, dano);
		habilidadeService.create(novaHabilidade);
	}
	
	public void update(Habilidade habilidadeAtualizado) {
		habilidadeService.update(habilidadeAtualizado);
	}
	
	public List<Habilidade> listAll(){
		return habilidadeService.listAll();
	}
	
	public Habilidade getById(Long id) {
		return habilidadeService.getById(id);
	}
	
	public void deleteAll() {
		habilidadeService.deleteAll();
	}
	
	public void deleteById(Long id) {
		habilidadeService.deleteById(id);
	}
}
