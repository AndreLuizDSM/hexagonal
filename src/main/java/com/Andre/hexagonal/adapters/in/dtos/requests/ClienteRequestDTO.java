package com.Andre.hexagonal.adapters.in.dtos.requests;

import jakarta.annotation.Nullable;

public record ClienteRequestDTO (String nome,
                                 String email,
                                 Integer idade,
                                 String cpf,
                                 @Nullable EnderecoRequestDTO endereco,
                                 double rendaMensal,
                                 Integer dataVencimentoFatura){
}
