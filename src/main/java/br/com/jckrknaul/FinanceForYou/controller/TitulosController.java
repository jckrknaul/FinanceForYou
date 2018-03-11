package br.com.jckrknaul.FinanceForYou.controller;

import br.com.jckrknaul.FinanceForYou.controller.page.PageWrapper;
import br.com.jckrknaul.FinanceForYou.model.*;
import br.com.jckrknaul.FinanceForYou.service.EntidadeService;
import br.com.jckrknaul.FinanceForYou.service.TipoPagamentoService;
import br.com.jckrknaul.FinanceForYou.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/titulos")
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

    @GetMapping
    public ModelAndView pesquisar(Titulo titulo, @PageableDefault(size = 6) Pageable pageable,
                                  HttpServletRequest httpServletRequest){
        ModelAndView mv = new ModelAndView("titulo/PesquisarTitulo");
        PageWrapper<Titulo> paginaWrapper =
                new PageWrapper<>(titulosService.porNome(titulo.getDescricao(), pageable), httpServletRequest);


        mv.addObject("pagina", paginaWrapper);
        mv.addObject("listaDeEntidades", entidadeService.listarTodos());
        //mv.addObject("titulos", titulosService.retornarFiltrados(titulo.getDescricao(), titulo.getEntidade()));
        return mv;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String excluir(@PathVariable("id") Long ID, RedirectAttributes attributes){
        titulosService.excluir(ID);
        attributes.addFlashAttribute("mensagem", "Título excluido com sucesso!");
        return "redirect:/titulos";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<?> novoTipoDePagamento(@RequestBody @Valid TipoPagamento tipoPagamento,
                                                                 BindingResult result){

        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getFieldError("descricao").getDefaultMessage());
        }

        tipoPagamento = tipoPagamentoService.salvar(tipoPagamento);
        return ResponseEntity.ok(tipoPagamento);
    }

    @GetMapping("/{id}")
    public ModelAndView editar(@PathVariable("id") Titulo titulo){
        ModelAndView mv = new ModelAndView(PAGE_INDEX);
        mv.addObject("listaDeEntidades", entidadeService.listarTodos());
        mv.addObject("todosOsTipos", Tipo.values());
        mv.addObject("todasAsSituacoes", Situacao.values());
        mv.addObject("tipoPagamento", tipoPagamentoService.listarTodos());
        mv.addObject(titulo);
        return mv;
    }


}
