package io.github.mr4torr.system.application.auth.usecases.dtos;

import io.github.mr4torr.system.core.auth.valueobjects.Email;

public record UserInbound(
    String name,
    Email email
) {}
