package io.github.mr4torr.system.infrastructure.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.core.auth.persistence.UserPersistence;
import io.github.mr4torr.system.core.auth.valueobjects.Email;
import io.github.mr4torr.system.infrastructure.auth.persistence.mappers.UserMapper;
import io.github.mr4torr.system.infrastructure.auth.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class UserPersistenceImpl implements UserPersistence {
    private final UserRepository repository;

    @Override
    public Optional<User> findByEmail(Email email) {
        return this.repository
            .findByEmail(email)
            .map(UserMapper.INSTANCE::modelJpaToEntity);
    }

    public User create(User user) {
        return UserMapper.INSTANCE.modelJpaToEntity(
            this.repository.save(
                UserMapper.INSTANCE.entityToModelJpa(user)
            )
        );
    }

    @Override
    public Boolean emailAlreadyExists(Email email) {
        return this.repository.existsByEmail(email);
    }

    @Override
    public Boolean remove(UUID userId) {
        try {
            UserJpa user = this.repository.findById(userId).orElseThrow();
            this.repository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
