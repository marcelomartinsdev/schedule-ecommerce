package br.com.schedule.ecommerce.repositories;

import br.com.schedule.ecommerce.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    ItemPedido findByProdutoId(Long produtoId);
}
