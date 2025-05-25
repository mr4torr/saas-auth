package io.github.mr4torr.system.infrastructure.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.Credential;
import io.github.mr4torr.system.core.auth.enums.ProviderEnum;
import io.github.mr4torr.system.core.auth.valueobjects.Password;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "credentials")
@NoArgsConstructor
public class CredentialJpa {
    @Id
    public UUID id;

    public UUID userId;

    public String hash;

    @Enumerated(EnumType.STRING)
    public ProviderEnum provider;

    public boolean isActive;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;
}
