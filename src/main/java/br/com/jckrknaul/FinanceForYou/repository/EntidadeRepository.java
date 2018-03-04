package br.com.jckrknaul.FinanceForYou.repository;

import br.com.jckrknaul.FinanceForYou.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long>{
    List<Entidade> findByNomeContainingIgnoreCase(String nome);
}
