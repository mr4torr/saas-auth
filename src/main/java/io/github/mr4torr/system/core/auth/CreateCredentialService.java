package io.github.mr4torr.system.core.auth;

import io.github.mr4torr.system.core.auth.entities.Credential;
import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.core.auth.enums.ProviderEnum;
import io.github.mr4torr.system.core.auth.persistence.CredentialPersistence;
import io.github.mr4torr.system.core.auth.persistence.UserPersistence;
import io.github.mr4torr.system.core.auth.valueobjects.Password;
import io.github.mr4torr.system.shared.exception.BusinessException;
import io.github.mr4torr.system.shared.exception.FieldException;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class CreateCredentialService {
    private final CredentialPersistence credentialPersistence;

    public CreateCredentialService(CredentialPersistence credentialPersistence) {
        this.credentialPersistence = credentialPersistence;
    }

    public Credential make(UUID userId, Password password) throws FieldException {
        Credential credential = credentialPersistence.create(
            Credential.newInstance(userId, password, ProviderEnum.API)
        );

        if (credential == null) {
            throw new BusinessException("error_sign_up_credential");
        }

        return credential;
    }
}
