package br.com.jckrknaul.FinanceForYou.repository;

import br.com.jckrknaul.FinanceForYou.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepositoty extends JpaRepository<Titulo, Long> {
}
