package br.edu.ifpb.dac.crudpersonagens.model.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Habilidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4165865658665824452L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int cooldown;
	private String descricao;
	private int dano;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "personagem_fk")
	private Personagem personagem;
	
	
	public Habilidade() {
		
	}
	
	public Habilidade(String nome, int cooldown, String descricao, int dano) {
		this.nome = nome;
		this.cooldown = cooldown;
		this.descricao = descricao;
		this.dano = dano;
	}
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
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	
	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cooldown, dano, descricao, id, nome, personagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habilidade other = (Habilidade) obj;
		return cooldown == other.cooldown && dano == other.dano && Objects.equals(descricao, other.descricao)
				&& id == other.id && Objects.equals(nome, other.nome) && Objects.equals(personagem, other.personagem);
	}

	@Override
	public String toString() {
		return "Habilidade [id=" + id + ", nome=" + nome + ", cooldown=" + cooldown + ", descricao=" + descricao
				+ ", dano=" + dano + ", personagem=" + personagem + "]";
	}

	
	
}
