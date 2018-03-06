package br.com.jckrknaul.FinanceForYou.service;

import br.com.jckrknaul.FinanceForYou.model.TipoPagamento;
import br.com.jckrknaul.FinanceForYou.repository.TipoPagtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagamentoService {

    @Autowired
    private TipoPagtoRepository tipoPagtoRepository;

    public List<TipoPagamento> listarTodos(){
        return tipoPagtoRepository.findAll();
    }

    public void excluir(Long ID){
        tipoPagtoRepository.delete(ID);
    }

}
