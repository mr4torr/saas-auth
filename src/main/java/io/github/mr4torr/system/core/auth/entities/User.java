package io.github.mr4torr.system.core.auth.entities;

import io.github.mr4torr.system.core.auth.enums.StatusEnum;
import io.github.mr4torr.system.core.auth.valueobjects.Email;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    public final UUID id;
    public String name;
    public Email email;
    public StatusEnum status;
    public String reasonStatus;
    public LocalDateTime emailVerifiedAt;
    public final LocalDateTime createdAt;
    public final LocalDateTime updatedAt;

    public static User newInstance(
        String name,
        Email email
    ) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(email, "Email cannot be null");

        return new User(
            UUID.randomUUID(),
            name,
            email,
            StatusEnum._default(),
            null,
            null,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }

    public User(
        UUID id,
        String name,
        Email email,
        StatusEnum status,
        String reasonStatus,
        LocalDateTime emailVerifiedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.reasonStatus = reasonStatus;
        this.emailVerifiedAt = emailVerifiedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public boolean isEmailVerified() {
        return emailVerifiedAt != null;
    }

    public boolean isActive() {
        return status == StatusEnum.ACTIVE;
    }
}