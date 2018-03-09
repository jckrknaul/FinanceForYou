package br.com.jckrknaul.FinanceForYou.controller;

import br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO;
import br.com.jckrknaul.FinanceForYou.exception.NegocioException;
import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.service.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/entidades")
public class EntidadesController {

    private final String PAGE_INDEX = "entidade/CadastrarEntidade";
    private final String PAGE_PESQUISAR = "entidade/PesquisarEntidade";

    @Autowired
    private EntidadeService entidadeService;

    @RequestMapping(value = "/novo")
    public String novo(Entidade entidade){
        return PAGE_INDEX;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public String salvar(@Valid Entidade entidade, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()){
            System.out.println("Tem erro!"+result.getAllErrors().toString());
            //TODO: mostrar msg de erro...
            return novo(entidade);
        }

        System.out.println("Entidade"+ entidade.toString());
        attributes.addFlashAttribute("mensagem", "Entidade salva com sucesso!");
        entidadeService.salvar(entidade);
        return "redirect:/entidades/novo";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView pesquisar(Entidade entidade){
        List<Entidade> entidades = entidadeService.pesquisarPorNome(entidade.getNome());
        ModelAndView mv = new ModelAndView(PAGE_PESQUISAR);
        mv.addObject("entidades", entidades);
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView editar(@PathVariable("id") Long ID){
        Entidade entidade = entidadeService.pesquisarPorId(ID);
        ModelAndView mv = new ModelAndView(PAGE_INDEX);
        mv.addObject("entidade", entidade);
        return mv;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String deletar(@PathVariable("id") Long ID, RedirectAttributes attributes){

        try{
            entidadeService.excluir(ID);
        }catch (NegocioException e){
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/entidades";
        }

        attributes.addFlashAttribute("mensagem", "Entidade excluída com sucesso!");
        return "redirect:/entidades";
    }

    @RequestMapping("/filtro")
    public @ResponseBody List<EntidadeDTO> filtradas(String nome){
        return entidadeService.pesquisarDTO(nome);
    }

}
