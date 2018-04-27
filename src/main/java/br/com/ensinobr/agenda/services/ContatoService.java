
package br.com.ensinobr.agenda.services;

import br.com.ensinobr.agenda.entities.Contato;
import java.util.List;

public interface ContatoService {

    public void salvar(Contato contato);
    
    public Contato buscarPorId(Long id);
    
    public List<Contato> listarTodos();
    
    public void removerPorId(Long id);
}
