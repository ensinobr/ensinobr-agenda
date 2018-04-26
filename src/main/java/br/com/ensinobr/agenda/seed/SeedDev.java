
package br.com.ensinobr.agenda.seed;

import br.com.ensinobr.agenda.entities.Categoria;
import br.com.ensinobr.agenda.entities.Contato;
import br.com.ensinobr.agenda.repositories.CategoriaRepository;
import br.com.ensinobr.agenda.repositories.ContatoRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SeedDev implements ApplicationListener<ContextRefreshedEvent>{

    private CategoriaRepository categoriaRepository;
    private ContatoRepository contatoRepository;

    public SeedDev(CategoriaRepository categoriaRepository, ContatoRepository contatoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.contatoRepository = contatoRepository;
    }
    
    public void onApplicationEvent(ContextRefreshedEvent e) {

        inserirDados();
    }
    
    public void inserirDados(){
        
        Categoria categoria1 = new Categoria();
        categoria1.setDescricao("Família");
        
        Categoria categoria2 = new Categoria();
        categoria2.setDescricao("Trabalho");
        
        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        
        Contato contato1 = new Contato();
        contato1.setNome("Bruno Rota");
        contato1.setTelefone("9999999");
        contato1.setEmail("brunorota@ensinobr.com.br");
        contato1.setCategoria(categoria1);
        
        Contato contato2 = new Contato();
        contato2.setNome("Durvalino");
        contato2.setTelefone("888888");
        contato2.setEmail("durvalino@ensinobr.com.br");
        contato2.setCategoria(categoria2);
        
        contatoRepository.save(contato1);
        contatoRepository.save(contato2);
    }
    
}
