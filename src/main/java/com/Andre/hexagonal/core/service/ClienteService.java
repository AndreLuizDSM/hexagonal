package com.Andre.hexagonal.core.service;

import com.Andre.hexagonal.core.gateways.in.IClienteServiceGateway;
import com.Andre.hexagonal.core.gateways.out.IClienteRepositoryGateway;
import com.Andre.hexagonal.core.domain.CartaoDomain;
import com.Andre.hexagonal.core.domain.ClienteDomain;

/*
    A service manda nos métodos de controle , por isso implementa ServiceGateway.
    A service depende dos métodos de repositório (database) , por isso a dependência.
    Métodos de de Repository é oque fará o serviço sujo.
    Tudo o que está no core, não terá qualquer uso de framework e import de fora do core.
 */


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
