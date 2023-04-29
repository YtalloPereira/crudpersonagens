package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Role;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;
import br.edu.ifpb.dac.crudpersonagens.model.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEnconderService passwordEncoderService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(
			String.format("Usuário com o nome informado não encontrado", username));
		}
		return user;
	}

	@Override
	public User save(User user) {
		if(user.getId() != null) {
			throw new IllegalStateException("Usuário já existe no banco");
		}
		
		passwordEncoderService.encryptPassword(user);
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.findDefault());
		user.setRoles(roles);
		
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		 userRepository.deleteById(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.getReferenceById(id);
	}

	@Override
	public User findByEmail(String email) {
		List<User> users =  userRepository.findAll();
		User expectedUser = null;
		for (User user : users) {
			if(user.getEmail().equals(email)) {
				expectedUser = user;
				return expectedUser;
			}
		}
		throw new UsernameNotFoundException("Usuário com o email informado não encontrado");
	}

	@Override
	public User findByUserName(String username) {
		List<User> users =  userRepository.findAll();
		User expectedUser = null;
		for (User user : users) {
			if(user.getUsername().equals(username)) {
				expectedUser = user;
				return expectedUser;
			}
		}
		throw new UsernameNotFoundException("Usuário com o nome informado não encontrado");
	}

	@Override
	public Iterable<User> findAll() {
		return  userRepository.findAll();
	}

	@Override
	public List<User> find(User filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
