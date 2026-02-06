package com.Andre.hexagonal.Adapters.in.dtos.responses;

public record CartaoResponseDTO (String numero,
                                 String dataExpiracao,
                                 String cvv,
                                 double limite){
}
