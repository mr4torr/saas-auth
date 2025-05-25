package io.github.mr4torr.system.infrastructure.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.Credential;
import io.github.mr4torr.system.core.auth.persistence.CredentialPersistence;
import io.github.mr4torr.system.infrastructure.auth.persistence.mappers.CredentialMapper;
import io.github.mr4torr.system.infrastructure.auth.persistence.repositories.CredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CredentialPersistenceImpl implements CredentialPersistence {
    private final CredentialRepository repository;

    @Override
    public Credential create(Credential input) {
        return CredentialMapper.INSTANCE.modelJpaToEntity(
            this.repository.save(
                CredentialMapper.INSTANCE.entityToModelJpa(input)
            )
        );
    }
}
