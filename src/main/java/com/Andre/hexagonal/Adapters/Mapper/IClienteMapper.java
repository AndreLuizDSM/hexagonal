package com.Andre.hexagonal.Adapters.Mapper;

import com.Andre.hexagonal.Adapters.in.dtos.requests.ClienteRequestDTO;
import com.Andre.hexagonal.Adapters.in.dtos.responses.ClienteResponseDTO;
import com.Andre.hexagonal.Adapters.outdatabase.entities.ClienteEntity;
import com.Andre.hexagonal.Core.domain.CartaoDomain;
import com.Andre.hexagonal.Core.domain.ClienteDomain;
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
