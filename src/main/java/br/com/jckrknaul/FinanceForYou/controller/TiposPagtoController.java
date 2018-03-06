package br.com.jckrknaul.FinanceForYou.controller;

import br.com.jckrknaul.FinanceForYou.model.TipoPagamento;
import br.com.jckrknaul.FinanceForYou.service.TipoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tiposPagto")
public class TiposPagtoController {

    private final String PAGE_INDEX = "tipoPagto/CadastroTipoPagto";

    @Autowired
    private TipoPagamentoService tipoPagtoService;

    @GetMapping
    public ModelAndView pesquisar(TipoPagamento tipoPagamento){
        ModelAndView mv = new ModelAndView("tipoPagto/PesquisarTipoPagto");
        mv.addObject("tiposPagto", tipoPagtoService.listarTodos());
        return mv;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String excluir(@PathVariable("id") Long ID){
        tipoPagtoService.excluir(ID);
        return "redirect:/tiposPagto";
    }

}
