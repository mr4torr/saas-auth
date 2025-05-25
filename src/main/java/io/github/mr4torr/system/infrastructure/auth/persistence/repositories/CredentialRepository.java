package io.github.mr4torr.system.infrastructure.auth.persistence.repositories;

import io.github.mr4torr.system.infrastructure.auth.persistence.CredentialJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CredentialRepository extends JpaRepository<CredentialJpa, UUID> {
}
