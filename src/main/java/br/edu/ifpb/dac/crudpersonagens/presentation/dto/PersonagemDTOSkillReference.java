package br.edu.ifpb.dac.crudpersonagens.presentation.dto;

import java.util.HashSet;
import java.util.Set;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Habilidade;

public class PersonagemDTOSkillReference {
	
	private long id;
	private long skillId;
	private Set<Habilidade> habilidades = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	public Set<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(Set<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
}
