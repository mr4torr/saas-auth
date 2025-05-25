package io.github.mr4torr.system.core.auth.entities;

import io.github.mr4torr.system.core.auth.enums.ProviderEnum;
import io.github.mr4torr.system.core.auth.valueobjects.Password;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Credential {
    public final UUID id;
    public UUID userId;
    public String hash;
    public ProviderEnum provider;
    public boolean isActive;
    public final LocalDateTime createdAt;
    public final LocalDateTime updatedAt;

    public static Credential newInstance(
        UUID userId,
        Password password,
        ProviderEnum provider
    ) {
        Objects.requireNonNull(password, "Hash cannot be null");
        Objects.requireNonNull(userId, "userId cannot be null");
        provider = Objects.requireNonNullElse(provider, ProviderEnum._default());

        return new Credential(
            UUID.randomUUID(),
            userId,
            password.toString(),
            provider,
            false,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }

    public Credential(
        UUID id,
        UUID userId,
        String hash,
        ProviderEnum provider,
        boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.hash = hash;
        this.provider = provider;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}