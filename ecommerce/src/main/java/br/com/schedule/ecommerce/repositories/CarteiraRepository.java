package br.com.schedule.ecommerce.repositories;

import br.com.schedule.ecommerce.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
