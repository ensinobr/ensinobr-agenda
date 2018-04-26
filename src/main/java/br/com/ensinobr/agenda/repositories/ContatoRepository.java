package br.com.ensinobr.agenda.repositories;

import br.com.ensinobr.agenda.entities.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> {
    
}
