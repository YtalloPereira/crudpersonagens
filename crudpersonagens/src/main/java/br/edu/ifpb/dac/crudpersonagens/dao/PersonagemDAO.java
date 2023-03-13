package br.edu.ifpb.dac.crudpersonagens.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.dac.crudpersonagens.model.Personagem;

@Repository
public interface PersonagemDAO extends JpaRepository<Personagem, Long>{

}
