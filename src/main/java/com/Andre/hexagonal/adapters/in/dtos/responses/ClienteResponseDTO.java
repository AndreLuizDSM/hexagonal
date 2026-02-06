package com.Andre.hexagonal.adapters.in.dtos.responses;

public record ClienteResponseDTO (String nome,
                                  String email,
                                  Long idade,
                                  String cpf,
                                  CartaoResponseDTO cartao){
}
