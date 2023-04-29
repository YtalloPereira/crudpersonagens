package br.edu.ifpb.dac.crudpersonagens.business.service;

import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

public interface AuthenticationService {
	
	public String localLogin(String email,String password);
	
	public User getLoggedUser();
}
