package com.Andre.hexagonal.adapters.in.controller;

import com.Andre.hexagonal.adapters.Mapper.IClienteMapper;
import com.Andre.hexagonal.core.gateways.in.IClienteServiceGateway;
import com.Andre.hexagonal.adapters.in.dtos.requests.ClienteRequestDTO;
import com.Andre.hexagonal.adapters.in.dtos.responses.ClienteResponseDTO;
import com.Andre.hexagonal.core.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    public final IClienteServiceGateway service;
    public final IClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(service.solicitarCartao(mapper.toDomain(clienteRequestDTO)));
            return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscarClientePorCpf(@RequestParam String cpf) {
        ClienteDomain domain = service.buscarPorCpf(cpf);
            return ResponseEntity.ok(mapper.toResponse(domain));
    }
}
