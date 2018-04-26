package br.com.ensinobr.agenda.repositories;

import br.com.ensinobr.agenda.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
    
}
