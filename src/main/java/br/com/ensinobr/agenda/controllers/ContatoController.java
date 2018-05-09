
package br.com.ensinobr.agenda.controllers;

import br.com.ensinobr.agenda.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {
    
    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }
    
    @GetMapping("/listar")
    public String listar(Model model){
     
        model.addAttribute("contatos", contatoService.listarTodos());
        
        return "contato/listar";
    }
}
