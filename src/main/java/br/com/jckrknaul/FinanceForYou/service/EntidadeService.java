package br.com.jckrknaul.FinanceForYou.service;

import br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO;
import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.repository.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadeService {
    @Autowired
    private EntidadeRepository entidadeRepository;

    public void salvar(Entidade entidade){
        entidadeRepository.save(entidade);
    }

    public List<Entidade> listarTodos(){
        List<Entidade> entidades = entidadeRepository.findAll();
        return entidades;
    }

    public List<Entidade> pesquisarPorNome(String nome){
        List<Entidade> entidades;
        if (nome == null){
            entidades = entidadeRepository.findAll();
        }else {
            entidades = entidadeRepository.findByNomeContainingIgnoreCase(nome);
        }
        return entidades;
    }

    public Entidade pesquisarPorId(Long ID){
        return entidadeRepository.findOne(ID);
    }

    public void excluir(Long ID){
        entidadeRepository.delete(ID);
    }

    public List<EntidadeDTO> pesquisarDTO(String nome){
        return entidadeRepository.filtradasDTO(nome);
    }
}
