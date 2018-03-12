package br.com.jckrknaul.FinanceForYou.repository;

import br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO;
import br.com.jckrknaul.FinanceForYou.model.Entidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long>{

    List<Entidade> findByNomeContainingIgnoreCase(String nome);

    @Query("select new br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO(id, nome) from Entidade where lower(nome) like %?1% ")
    List<EntidadeDTO> filtradasDTO(String nome);

    @Query("select new br.com.jckrknaul.FinanceForYou.dto.EntidadeDTO(id, nome) from Entidade ")
    List<EntidadeDTO> listarTodosDTO();

    @Query("select e from Entidade e where nome like %?1% or ?1 is null order by e.nome")
    Page<Entidade> porNome(String nome, Pageable pageable);
}
