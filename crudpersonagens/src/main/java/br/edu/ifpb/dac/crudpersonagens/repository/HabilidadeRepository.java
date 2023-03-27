package br.edu.ifpb.dac.crudpersonagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.dac.crudpersonagens.model.Habilidade;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Long>{

}
