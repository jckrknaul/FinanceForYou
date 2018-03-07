package br.com.jckrknaul.FinanceForYou.repository;

import br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO;
import br.com.jckrknaul.FinanceForYou.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long>{

    List<Entidade> findByNomeContainingIgnoreCase(String nome);

    @Query("select new br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO(id, nome) from Entidade where lower(nome) like %?1% ")
    List<EntidadeDTO> filtradasDTO(String nome);
}
