package br.com.jckrknaul.FinanceForYou.service;

import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.model.Titulo;
import br.com.jckrknaul.FinanceForYou.repository.EntidadeRepository;
import br.com.jckrknaul.FinanceForYou.repository.TituloRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TituloService {

    @Autowired
    private TituloRepositoty tituloRepositoty;

    public void salvar(Titulo titulo){
        titulo.setDataEmissao(new Date());
        tituloRepositoty.save(titulo);
    }

    public List<Titulo> listarTodos(){
        return tituloRepositoty.findAll();
    }

    public List<Titulo> retornarFiltrados(String descricao, Entidade entidade) {
        if (descricao == null) {
            return tituloRepositoty.findAll();
        } else
            return tituloRepositoty.filtrados(descricao, entidade);
    }

    public void excluir(Long ID){
        tituloRepositoty.delete(ID);
    }


}
