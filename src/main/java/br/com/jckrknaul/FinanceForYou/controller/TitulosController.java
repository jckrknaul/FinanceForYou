package br.com.jckrknaul.FinanceForYou.controller;

import br.com.jckrknaul.FinanceForYou.model.Situacao;
import br.com.jckrknaul.FinanceForYou.model.Tipo;
import br.com.jckrknaul.FinanceForYou.model.Titulo;
import br.com.jckrknaul.FinanceForYou.service.EntidadeService;
import br.com.jckrknaul.FinanceForYou.service.TipoPagamentoService;
import br.com.jckrknaul.FinanceForYou.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("titulos")
public class TitulosController {

    private final String PAGE_INDEX = "titulo/CadastroTitulo";

    @Autowired
    private EntidadeService entidadeService;

    @Autowired
    private TituloService titulosService;

    @Autowired
    private TipoPagamentoService tipoPagamentoService;

    @RequestMapping(value = "/novo")
    public ModelAndView index(Titulo titulo){
        ModelAndView mv = new ModelAndView(PAGE_INDEX);
        mv.addObject("listaDeEntidades", entidadeService.listarTodos());
        mv.addObject("todosOsTipos", Tipo.values());
        mv.addObject("todasAsSituacoes", Situacao.values());
        mv.addObject("tipoPagamento", tipoPagamentoService.listarTodos());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Titulo titulo, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            return index(titulo);
        }

        titulosService.salvar(titulo);
        redirectAttributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso!");
        return new ModelAndView("redirect:/titulos/novo");
    }
}
