package br.edu.ifpb.dac.crudpersonagens.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	
	
	
	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getLoggedUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
