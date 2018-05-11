
package br.com.ensinobr.agenda.controllers;

import br.com.ensinobr.agenda.entities.Contato;
import br.com.ensinobr.agenda.services.CategoriaService;
import br.com.ensinobr.agenda.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {
    
    private ContatoService contatoService;
    
    private CategoriaService categoriaService;

    public ContatoController(ContatoService contatoService, CategoriaService categoriaService) {
        this.contatoService = contatoService;
        this.categoriaService = categoriaService;
    }
    
    @GetMapping("/listar")
    public String listar(Model model){
     
        model.addAttribute("contatos", contatoService.listarTodos());
        
        return "/contato/listar";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable("id") Long id, Model model){
    
        System.out.println("EDITARRRRRRRRRRRR: " + id);
        
        model.addAttribute("contato", contatoService.buscarPorId(id));
        model.addAttribute("categorias", categoriaService.listarTodas());
        
        return "/contato/formulario";
    }
    
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable("id") Long id){
        
        contatoService.removerPorId(id);
        
        return "redirect:/contato/listar";
    }
    
    @GetMapping("/novo")
    public String novo(Model model){
        
        model.addAttribute("contato", new Contato());
        model.addAttribute("categorias", categoriaService.listarTodas());
        
        return "/contato/formulario";
    }
    
    @PostMapping("/salvar")
    public String salvar(Contato contato){
        
        System.out.println(contato);
        
        contatoService.salvar(contato);
        
        return "redirect:/contato/listar";
    }
    
}
