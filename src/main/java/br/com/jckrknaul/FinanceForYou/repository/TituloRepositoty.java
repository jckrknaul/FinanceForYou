package br.com.jckrknaul.FinanceForYou.repository;

import br.com.jckrknaul.FinanceForYou.model.Entidade;
import br.com.jckrknaul.FinanceForYou.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TituloRepositoty extends JpaRepository<Titulo, Long> {

    @Query("select t from Titulo t join fetch t.tipoDePagamento where t.descricao like %?1% and (t.entidade = ?2 or ?2 is null)")
    List<Titulo> filtrados(String descricao, Entidade entidade);

}
