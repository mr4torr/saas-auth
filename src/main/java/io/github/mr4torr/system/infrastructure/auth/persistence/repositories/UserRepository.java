package io.github.mr4torr.system.infrastructure.auth.persistence.repositories;

import io.github.mr4torr.system.core.auth.valueobjects.Email;
import io.github.mr4torr.system.infrastructure.auth.persistence.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserJpa, UUID> {

    boolean existsByEmail(Email email);

     Optional<UserJpa> findByEmail(Email email);
}
