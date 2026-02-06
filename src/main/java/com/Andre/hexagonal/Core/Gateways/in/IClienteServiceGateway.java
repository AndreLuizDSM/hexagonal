package com.Andre.hexagonal.Core.Gateways.in;

import com.Andre.hexagonal.Core.domain.ClienteDomain;

public interface IClienteServiceGateway {

    ClienteDomain solicitarCartao(ClienteDomain domain);

    ClienteDomain buscarPorCpf(String cpf);
}
