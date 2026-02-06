package com.Andre.hexagonal.Adapters.outdatabase.entities;

import com.Andre.hexagonal.Core.domain.ClienteDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private LocalDate dataExpiracao;
    private String cvv;
    private double limite;
    private double avaiableLimite;
    private LocalDate ultimaAlteracaoLimite;
    private Integer dataVencimentoFatura;
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private ClienteDomain cliente;
}
