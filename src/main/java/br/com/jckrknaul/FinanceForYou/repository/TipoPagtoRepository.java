package br.com.jckrknaul.FinanceForYou.repository;

import br.com.jckrknaul.FinanceForYou.model.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagtoRepository extends JpaRepository<TipoPagamento, Long>{
}
