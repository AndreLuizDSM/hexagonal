package com.Andre.hexagonal.adapters.outdatabase;

import com.Andre.hexagonal.adapters.Mapper.IClienteMapper;
import com.Andre.hexagonal.adapters.outdatabase.repositories.IClienteJpaRepository;
import com.Andre.hexagonal.core.domain.ClienteDomain;
import com.Andre.hexagonal.core.gateways.out.IClienteRepositoryGateway;
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
