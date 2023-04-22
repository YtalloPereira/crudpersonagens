package br.edu.ifpb.dac.crudpersonagens.model.entity;

import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.Entity;

@Entity
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -447111205657462416L;
	
	private long id;
	private String nome;
	
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
