
package br.com.ensinobr.agenda.services;

import br.com.ensinobr.agenda.entities.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public void salvar(Categoria categoria);
    
    public Categoria buscarPorId(Long id);
    
    public List<Categoria> listarTodas();
    
    public void removerPorId(Long id);
}
