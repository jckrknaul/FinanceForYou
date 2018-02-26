package br.com.jckrknaul.FinanceForYou.service;

import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.repository.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntidadeService {
    @Autowired
    private EntidadeRepository entidadeRepository;

    public void salvar(Entidade entidade){
        entidadeRepository.save(entidade);
    }
}
