package br.com.jckrknaul.FinanceForYou.service;

import br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO;
import br.com.jckrknaul.FinanceForYou.exception.NegocioException;
import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.repository.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try{
            entidadeRepository.delete(ID);
        }catch (DataIntegrityViolationException e){
            throw new NegocioException("Erro ao excuir a mensagem. "+
                    "Necessário primeiramente excluir os títulos vinculados! ");
        }

    }

    public List<EntidadeDTO> pesquisarDTO(String nome){
        return entidadeRepository.filtradasDTO(nome);
    }
}
