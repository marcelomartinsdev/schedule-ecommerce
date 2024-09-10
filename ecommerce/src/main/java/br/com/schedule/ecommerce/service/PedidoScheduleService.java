package br.com.schedule.ecommerce.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PedidoScheduleService {
    private PedidoService pedidoService;

    @Scheduled(fixedRate = 60000) //1 minuto
    public void confirmarPagamentoPedido() {
        pedidoService.confirmarPagamento();
    }
}
