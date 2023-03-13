package br.edu.ifpb.dac.crudpersonagens.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Personagem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1610678633051025784L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String classe;
	private int hp;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "personagem_id")
	private List<Habilidade> habilidades;
	
	public Personagem() {
	}
	public Personagem(String nome, String classe, int hp, List<Habilidade> habilidades) {
		this.nome = nome;
		this.classe = classe;
		this.hp = hp;
		this.habilidades = habilidades;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	@Override
	public int hashCode() {
		return Objects.hash(classe, habilidades, hp, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personagem other = (Personagem) obj;
		return Objects.equals(classe, other.classe) && Objects.equals(habilidades, other.habilidades) && hp == other.hp
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "Personagem [id=" + id + ", nome=" + nome + ", classe=" + classe + ", hp=" + hp + ", habilidades="
				+ habilidades + "]";
	}
	
}
