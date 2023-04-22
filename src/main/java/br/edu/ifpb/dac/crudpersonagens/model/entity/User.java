package br.edu.ifpb.dac.crudpersonagens.model.entity;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4410408022044831838L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String senha;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	
	public User(){
		
	}
	
	public User(String nome, String email, String senha, List<Role> roles) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.roles = roles;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, roles, senha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(roles, other.roles) && Objects.equals(senha, other.senha);
	}
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", roles=" + roles + "]";
	}
	
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.nome;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
