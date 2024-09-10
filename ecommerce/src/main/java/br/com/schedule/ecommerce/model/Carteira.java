package br.com.schedule.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carteira extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cliente cliente;

    private double saldo;
}
