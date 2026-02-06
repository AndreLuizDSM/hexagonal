package com.Andre.hexagonal.Adapters.outdatabase;

import com.Andre.hexagonal.Adapters.Mapper.IClienteMapper;
import com.Andre.hexagonal.Adapters.outdatabase.repositories.IClienteJpaRepository;
import com.Andre.hexagonal.Core.domain.ClienteDomain;
import com.Andre.hexagonal.Core.Gateways.out.IClienteRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements IClienteRepositoryGateway {

    private final IClienteJpaRepository repository;
    private final IClienteMapper mapper;

    @Override
    public ClienteDomain salvar(ClienteDomain domain) {

        return mapper.paraDomain(
                repository.save(
                    mapper.paraEntity(domain)));
    }

    @Override
    public Boolean emailExiste(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Optional<ClienteDomain> buscarCpf(String cpf) {

        return repository.findByCpf(cpf)
                .map(mapper::paraDomain);
    }
}
