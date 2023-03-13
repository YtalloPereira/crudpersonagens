package br.edu.ifpb.dac.crudpersonagens.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.dao.HabilidadeDAO;
import br.edu.ifpb.dac.crudpersonagens.model.Habilidade;

@Service
public class HabilidadeService {
	
	@Autowired
	private HabilidadeDAO habilidadeDAO;
	
	public void create(Habilidade novaHabilidade) {
		habilidadeDAO.save(novaHabilidade);
	}
	
	public void update(Habilidade habilidadeAtualizado) {
		habilidadeDAO.save(habilidadeAtualizado);
	}
	
	public List<Habilidade> listAll(){
		return habilidadeDAO.findAll();
	}
	
	public Habilidade getById(Long id) {
		return habilidadeDAO.getReferenceById(id);
	}
	
	public void deleteAll() {
		habilidadeDAO.deleteAll();
	}
	
	public void deleteById(Long id) {
		habilidadeDAO.deleteById(id);
	}
}
