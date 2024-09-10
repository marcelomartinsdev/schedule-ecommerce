package br.com.schedule.ecommerce.service;

import br.com.schedule.ecommerce.model.Historico;
import br.com.schedule.ecommerce.model.Pedido;
import br.com.schedule.ecommerce.repositories.HistoricoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HistoricoService {
    @Autowired
    private HistoricoRepository historicoRepository;

    public void salvarHistorico(Pedido pedido) {
        Historico historico = new Historico();
        historico.setPedido(pedido);
        historico.setStatusAtualPedido(pedido.getStatusPedido());
        historicoRepository.save(historico);
        log.info("Pedido salvo no historico!");
    }
}
