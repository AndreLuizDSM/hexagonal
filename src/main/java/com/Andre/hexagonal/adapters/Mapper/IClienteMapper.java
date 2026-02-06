package com.Andre.hexagonal.adapters.Mapper;

import com.Andre.hexagonal.adapters.in.dtos.requests.ClienteRequestDTO;
import com.Andre.hexagonal.adapters.in.dtos.responses.ClienteResponseDTO;
import com.Andre.hexagonal.adapters.outdatabase.entities.ClienteEntity;
import com.Andre.hexagonal.core.domain.CartaoDomain;
import com.Andre.hexagonal.core.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    ClienteEntity paraEntity(ClienteDomain domain);

    ClienteDomain paraDomain(ClienteEntity entity);

    @Mapping(target = "cartao", expression = "java(toCartaoEntity(cliente)")
    ClienteDomain toDomain(ClienteRequestDTO dto);

    ClienteResponseDTO toResponse(ClienteDomain domain);

    @Mapping(source = "dataVencimentoFatura", target = "dataVencimentoFatura")
    CartaoDomain toCartaoDomain(ClienteRequestDTO dto);
}
