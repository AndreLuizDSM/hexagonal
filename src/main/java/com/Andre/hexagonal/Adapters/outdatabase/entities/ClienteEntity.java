package com.Andre.hexagonal.Adapters.outdatabase.entities;

import com.Andre.hexagonal.Core.domain.CartaoDomain;
import com.Andre.hexagonal.Core.domain.EnderecoDomain;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
@Entity
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String cpf;
    private double rendaMensal;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private EnderecoDomain endereco;
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private CartaoDomain cartao;
}
