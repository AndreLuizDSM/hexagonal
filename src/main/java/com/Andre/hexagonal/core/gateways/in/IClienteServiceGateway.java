package com.Andre.hexagonal.core.gateways.in;

import com.Andre.hexagonal.core.domain.ClienteDomain;

/*
    O controller depende de mim para funcionar.
    Eu dependo do ServiceCore para funcionar.
 */

public interface IClienteServiceGateway {

    ClienteDomain solicitarCartao(ClienteDomain domain);

    ClienteDomain buscarPorCpf(String cpf);
}
