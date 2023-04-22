package br.edu.ifpb.dac.crudpersonagens.business.service;

import br.edu.ifpb.dac.crudpersonagens.model.entity.User;


public interface TokenService {
	
	String generate(User user);
	
	Claims getClaims(String token) throws ExpiredJwtException;
	
}
