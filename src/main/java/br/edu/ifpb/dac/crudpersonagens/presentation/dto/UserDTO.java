package br.edu.ifpb.dac.crudpersonagens.presentation.dto;

import java.util.List;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Role;

public class UserDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String[] roles;
	
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
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] strings) {
		this.roles = strings;
	}
	
	

}
