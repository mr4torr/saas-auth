package io.github.mr4torr.system.application.auth.usecases.dtos;

public record RegisterUserInbound(
    UserInbound user,
    CredentialInbound credential
) {}
