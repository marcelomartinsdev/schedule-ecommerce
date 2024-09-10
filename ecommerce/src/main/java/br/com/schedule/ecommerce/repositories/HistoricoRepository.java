package br.com.schedule.ecommerce.repositories;

import br.com.schedule.ecommerce.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
