package br.com.jckrknaul.FinanceForYou.service;

import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.model.Titulo;
import br.com.jckrknaul.FinanceForYou.repository.EntidadeRepository;
import br.com.jckrknaul.FinanceForYou.repository.TituloRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TituloService {

    @Autowired
    private TituloRepositoty tituloRepositoty;

    public void salvar(Titulo titulo){
        titulo.setDataEmissao(new Date());
        tituloRepositoty.save(titulo);
    }

}
