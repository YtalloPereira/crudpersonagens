package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Habilidade;
import br.edu.ifpb.dac.crudpersonagens.model.repository.HabilidadeRepository;

@Service
public class HabilidadeService {
	
	@Autowired
	private HabilidadeRepository habilidadeDAO;
	
	public Habilidade create(Habilidade novaHabilidade) {
		return habilidadeDAO.save(novaHabilidade);
	}
	
	public Habilidade update(Habilidade habilidadeAtualizado) {
		return habilidadeDAO.save(habilidadeAtualizado);
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
