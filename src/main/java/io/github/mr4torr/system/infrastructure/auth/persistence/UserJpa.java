package io.github.mr4torr.system.infrastructure.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.core.auth.enums.StatusEnum;
import io.github.mr4torr.system.core.auth.valueobjects.Email;
import io.github.mr4torr.system.infrastructure.auth.persistence.converters.EmailAttributeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserJpa {
    @Id
    public UUID id;

    public String name;

    @Column(columnDefinition = "string")
    @Convert(converter = EmailAttributeConverter.class)
    public Email email;

    @Enumerated(EnumType.STRING)
    public StatusEnum status;

    public String reasonStatus;

    public LocalDateTime emailVerifiedAt;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;
}
