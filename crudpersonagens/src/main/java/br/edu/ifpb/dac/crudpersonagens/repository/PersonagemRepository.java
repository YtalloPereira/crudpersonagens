package br.edu.ifpb.dac.crudpersonagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.dac.crudpersonagens.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long>{

}
