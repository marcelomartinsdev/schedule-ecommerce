package br.com.schedule.ecommerce.service;

import br.com.schedule.ecommerce.model.Carteira;
import br.com.schedule.ecommerce.repositories.CarteiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    private CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public Carteira getCarteira(Long clienteId) {
        return carteiraRepository.findById(clienteId).get();
    }

    @Transactional
    public void save(Carteira carteira) {
        carteiraRepository.save(carteira);
    }
}
