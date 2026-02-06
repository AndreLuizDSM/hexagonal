package com.Andre.hexagonal.Adapters.in.dtos.requests;

public record EnderecoRequestDTO (String rua,
                                  String numero,
                                  String complemento,
                                  String cidade,
                                  String estado,
                                  String cep){
}
