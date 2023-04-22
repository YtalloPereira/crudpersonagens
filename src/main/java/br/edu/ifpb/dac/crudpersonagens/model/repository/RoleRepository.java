package br.edu.ifpb.dac.crudpersonagens.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {
	public Optional<Role> findByName(String name);
	public boolean existsByName(String name);
}
