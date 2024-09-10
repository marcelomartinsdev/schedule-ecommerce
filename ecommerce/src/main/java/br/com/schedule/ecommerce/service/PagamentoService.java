package br.com.schedule.ecommerce.service;

import br.com.schedule.ecommerce.model.Pagamento;
import br.com.schedule.ecommerce.repositories.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PagamentoService {
    private PagamentoRepository pagamentoRepository;

    public void save(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }

    public Pagamento getPagamento(Long idPedido) {
        return pagamentoRepository.buscarPagamento(idPedido);
    }
}
