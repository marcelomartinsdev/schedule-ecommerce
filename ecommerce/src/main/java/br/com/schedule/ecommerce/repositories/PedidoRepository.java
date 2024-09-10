package br.com.schedule.ecommerce.repositories;

import br.com.schedule.ecommerce.enums.StatusPedido;
import br.com.schedule.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
