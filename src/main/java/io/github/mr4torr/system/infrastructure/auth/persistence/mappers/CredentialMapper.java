package io.github.mr4torr.system.infrastructure.auth.persistence.mappers;


import io.github.mr4torr.system.core.auth.entities.Credential;
import io.github.mr4torr.system.infrastructure.auth.persistence.CredentialJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CredentialMapper {
    CredentialMapper INSTANCE = Mappers.getMapper(CredentialMapper.class);

    Credential modelJpaToEntity(CredentialJpa resource);

    CredentialJpa entityToModelJpa(Credential resource);
}
