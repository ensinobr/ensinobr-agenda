
package br.com.ensinobr.agenda.services;

import br.com.ensinobr.agenda.entities.Categoria;
import br.com.ensinobr.agenda.repositories.CategoriaRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    @Override
    public void salvar(Categoria categoria) {
        
        this.categoriaRepository.save(categoria);
        
    }

    @Override
    public Categoria buscarPorId(Long id) {

        Optional<Categoria> o = this.categoriaRepository.findById(id);
        
        
        return o.get();
    }

    @Override
    public List<Categoria> listarTodas() {

        List<Categoria> categorias = new ArrayList<>();
        
        Iterator<Categoria> iterator = this.categoriaRepository.findAll().iterator();
        
        while(iterator.hasNext()){
            
            categorias.add(iterator.next());
        }
        
        return categorias;
    }

    @Override
    public void removerPorId(Long id) {

        this.categoriaRepository.deleteById(id);
    }
    
}
