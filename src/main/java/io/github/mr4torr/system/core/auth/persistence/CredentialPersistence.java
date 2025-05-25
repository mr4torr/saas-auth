package io.github.mr4torr.system.core.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.Credential;

public interface CredentialPersistence {
        Credential create(Credential credential);
}
