package io.github.mr4torr.system.core.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.core.auth.valueobjects.Email;

import java.util.Optional;
import java.util.UUID;

public interface UserPersistence {
        User create(User user);

        Boolean emailAlreadyExists(Email email);

        Boolean remove(UUID userId);

        Optional<User> findByEmail(Email email);
}
