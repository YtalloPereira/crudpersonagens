package br.edu.ifpb.dac.crudpersonagens.presentation.dto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Habilidade;

public class PersonagemDTO {
	
	private long id;
	private String nome;
	private String classe;
	private int hp;
	private List<Habilidade> habilidades;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
}
