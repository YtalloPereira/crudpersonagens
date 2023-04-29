package br.edu.ifpb.dac.crudpersonagens.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Override
	public User getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User) authentication.getPrincipal();
	}
	
	@Override
	public String localLogin(String username, String password) {	
		//Excecao sera lancada em caso de falha
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		User user = userService.findByUserName(username);
		
		return tokenService.generate(user);
	}
}
