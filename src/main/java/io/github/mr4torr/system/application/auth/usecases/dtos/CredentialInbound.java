package io.github.mr4torr.system.application.auth.usecases.dtos;

import io.github.mr4torr.system.core.auth.enums.ProviderEnum;
import io.github.mr4torr.system.core.auth.valueobjects.Password;

public record CredentialInbound(
    Password password,
    Password passwordConfirmation,
    ProviderEnum provider
) {
    public CredentialInbound(Password password, Password passwordConfirmation) {
        this(password, passwordConfirmation, ProviderEnum._default());
    }
}
