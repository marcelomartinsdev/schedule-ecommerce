package br.com.schedule.ecommerce.service;

import br.com.schedule.ecommerce.enums.StatusPagamento;
import br.com.schedule.ecommerce.enums.StatusPedido;
import br.com.schedule.ecommerce.model.Carteira;
import br.com.schedule.ecommerce.model.Pagamento;
import br.com.schedule.ecommerce.model.Pedido;
import br.com.schedule.ecommerce.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PedidoService {
    private PedidoRepository pedidoRepository;

    private CarteiraService carteiraService;

    private PagamentoService pagamentoService;

    private HistoricoService historicoService;


    @Transactional
    public void confirmarPagamento() {
        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO_CONFIMACO_PAGAMENTO);
        if (pedidos.isEmpty()) {
            return;
        }
        pedidos.forEach(p -> {
            Carteira carteira = carteiraService.getCarteira(p.getCliente().getId());
            Pagamento pagamento = pagamentoService.getPagamento(p.getPedidoId());
            if (carteira.getSaldo() >= p.getValorTotal()) {
                p.setStatusPedido(StatusPedido.AGUARDANDO_EXPEDICAO);
                carteira.setSaldo(carteira.getSaldo() - p.getValorTotal());
                pagamento.setStatusPagamento(StatusPagamento.CONFIRMADO);
                carteiraService.save(carteira);
                log.info("Pedido {} Aprovado!", p.getPedidoId());
            } else {
                p.setStatusPedido(StatusPedido.CANCELADO);
                pagamento.setStatusPagamento(StatusPagamento.REPROVADO);
                log.info("Pedido {} Reprovado!", p.getPedidoId());
            }
            pagamentoService.save(pagamento);
            pedidoRepository.save(p);
            historicoService.salvarHistorico(p);
        });
    }
}
