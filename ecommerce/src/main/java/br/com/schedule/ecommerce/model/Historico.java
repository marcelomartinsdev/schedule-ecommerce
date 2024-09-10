package br.com.schedule.ecommerce.model;

import br.com.schedule.ecommerce.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Historico extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
    @Enumerated(value = EnumType.STRING)
    private StatusPedido statusAtualPedido;
}