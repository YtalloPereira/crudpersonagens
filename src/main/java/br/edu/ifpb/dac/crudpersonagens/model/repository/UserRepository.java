package br.edu.ifpb.dac.crudpersonagens.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
