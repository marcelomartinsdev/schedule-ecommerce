package br.com.schedule.ecommerce.repositories;

import br.com.schedule.ecommerce.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @Query(value = "select * from pagamento p where p.pedido_id = :idPedido", nativeQuery = true)
    Pagamento buscarPagamento(Long idPedido);
}
