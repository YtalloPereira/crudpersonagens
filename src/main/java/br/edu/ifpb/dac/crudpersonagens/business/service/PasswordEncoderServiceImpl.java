package br.edu.ifpb.dac.crudpersonagens.business.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;


@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEnconderService{

	@Override
	public void encryptPassword(User user) {
		if(user.getPassword() != null) {
			String encryptredPassword = encode(user.getPassword());
			user.setSenha(encryptredPassword);
		}
		
	}
}
