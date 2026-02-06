package com.Andre.hexagonal.adapters.outdatabase.repositories;

import com.Andre.hexagonal.adapters.outdatabase.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    boolean existsByEmail(String email);

    Optional<ClienteEntity> findByCpf(String cpf);
}
