package br.com.jckrknaul.FinanceForYou.controller;

import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.service.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/entidades")
public class EntidadesController {

    private final String PAGE_INDEX = "entidade/CadastrarEntidade";

    @Autowired
    private EntidadeService entidadeService;

    @RequestMapping(value = "/novo")
    public String novo(Entidade entidade){
        return PAGE_INDEX;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public String salvar(@Valid Entidade entidade, BindingResult result){

        if (result.hasErrors()){
            System.out.println("Tem erro!"+result.getAllErrors().toString());
            //TODO: mostrar msg de erro...
            return novo(entidade);
        }

        System.out.println("Entidade"+ entidade.toString());
        entidadeService.salvar(entidade);
        return "redirect:/entidades/novo";
    }

}
