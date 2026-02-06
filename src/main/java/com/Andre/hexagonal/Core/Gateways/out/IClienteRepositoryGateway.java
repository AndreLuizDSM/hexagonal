package com.Andre.hexagonal.Core.Gateways.out;

import com.Andre.hexagonal.Core.domain.ClienteDomain;

import java.util.Optional;

public interface IClienteRepositoryGateway {

    ClienteDomain salvar(ClienteDomain cliente);
    Boolean emailExiste(String email);
    Optional<ClienteDomain> buscarCpf(String cpf);
}
