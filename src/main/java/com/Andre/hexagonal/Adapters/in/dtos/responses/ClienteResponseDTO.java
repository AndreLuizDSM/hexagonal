package com.Andre.hexagonal.Adapters.in.dtos.responses;

public record ClienteResponseDTO (String nome,
                                  String email,
                                  Long idade,
                                  String cpf,
                                  CartaoResponseDTO cartao){
}
