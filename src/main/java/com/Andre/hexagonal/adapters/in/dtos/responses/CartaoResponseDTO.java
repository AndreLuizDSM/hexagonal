package com.Andre.hexagonal.adapters.in.dtos.responses;

public record CartaoResponseDTO (String numero,
                                 String dataExpiracao,
                                 String cvv,
                                 double limite){
}
