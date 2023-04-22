package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Role;
import br.edu.ifpb.dac.crudpersonagens.model.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void createDefaultValues() {
		for (AVAILABLE_ROLES availableRole : AVAILABLE_ROLES.values()) {
			Role role = findByName(availableRole.name());
			
			if(role == null) {
				role = new Role();
				role.setNome(availableRole.name());
				roleRepository.save(role);
			}
		}
	}

	@Override
	public Role findByName(String name) {
		if(name == null) {
			throw new IllegalStateException("Nome não pode ser nulo");
		}
		
		Optional<Role> optional = roleRepository.findByName(name);
		
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Role findDefault() {
		return findByName(AVAILABLE_ROLES.USER.name());
	}

}
