package br.edu.ifpb.dac.crudpersonagens.business.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

@Service
public interface PasswordEnconderService extends PasswordEncoder {
	void encryptPassword(User user);
}
