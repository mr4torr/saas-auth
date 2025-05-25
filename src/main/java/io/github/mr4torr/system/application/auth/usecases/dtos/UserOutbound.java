package io.github.mr4torr.system.application.auth.usecases.dtos;

import io.github.mr4torr.system.core.auth.enums.StatusEnum;
import io.github.mr4torr.system.core.auth.valueobjects.Email;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserOutbound(
    UUID id,
    String name,
    Email email,
    StatusEnum status,
    String reasonStatus,
    LocalDateTime emailVerifiedAt,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
