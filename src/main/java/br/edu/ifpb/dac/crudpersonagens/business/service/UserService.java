package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

@Service
public interface UserService extends UserDetailsService{
	
	public User save(User user);
	
	public User update(User user);
	
	public void delete(Long id);
	
	public User findById(Long id);
	
	public User findByEmail(String email);
	
	public User findByUserName(String username);
	
	public Iterable<User> findAll();
	
	public List<User> find(User filter);
}
