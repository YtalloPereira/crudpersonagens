package br.edu.ifpb.dac.crudpersonagens.business.service;

import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.crudpersonagens.model.entity.Role;

@Service
public interface RoleService {

	public enum AVAILABLE_ROLES{ADMIN,USER}

	public void createDefaultValues();

	public Role findByName(String name);

	public Role findDefault();

}
