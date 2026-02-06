package com.Andre.hexagonal.Core.service;

import com.Andre.hexagonal.Core.Gateways.in.IClienteServiceGateway;
import com.Andre.hexagonal.Core.Gateways.out.IClienteRepositoryGateway;
import com.Andre.hexagonal.Core.domain.CartaoDomain;
import com.Andre.hexagonal.Core.domain.ClienteDomain;


public class ClienteService implements IClienteServiceGateway {

    private final IClienteRepositoryGateway gateway;
    private final GeraDadosCartaoService geraCartao;

    public ClienteService(IClienteRepositoryGateway gateway, GeraDadosCartaoService geraCartao) {
        this.gateway = gateway;
        this.geraCartao = geraCartao;
    }

    @Override
    public ClienteDomain solicitarCartao(ClienteDomain cliente) {
        if (gateway.emailExiste(cliente.getEmail())) {
            throw new IllegalArgumentException("Usuário já possui um cartão");
        }
        CartaoDomain cartao = geraCartao.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
            return gateway.salvar(cliente);
    }

    @Override
    public ClienteDomain buscarPorCpf(String cpf) {
        return gateway.buscarCpf(cpf).orElseThrow(
                ()-> new IllegalArgumentException("Cpf não encontrado " + cpf));
    }
}
