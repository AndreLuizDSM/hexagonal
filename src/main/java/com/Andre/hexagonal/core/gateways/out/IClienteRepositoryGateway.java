package com.Andre.hexagonal.core.gateways.out;

import com.Andre.hexagonal.core.domain.ClienteDomain;
import java.util.Optional;

/*
    O ServiceCore depende de mim para funcionar.
    Eu dependo do Adapter para funcionar.
 */

public interface IClienteRepositoryGateway {

    ClienteDomain salvar(ClienteDomain cliente);
    Boolean emailExiste(String email);
    Optional<ClienteDomain> buscarCpf(String cpf);
}
