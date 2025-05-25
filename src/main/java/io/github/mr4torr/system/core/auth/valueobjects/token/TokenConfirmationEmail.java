package io.github.mr4torr.system.core.auth.valueobjects.token;

import io.github.mr4torr.system.core.auth.enums.TokenEnum;
import io.github.mr4torr.system.core.auth.valueobjects.token.contracts.TokenPayloadContract;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenConfirmationEmail implements TokenPayloadContract {

    private final UUID id;

    public TokenConfirmationEmail(UUID id) {
        this.id = id;
    }

    public Map<String, String> toArray() {
        Map<String, String> result = new HashMap<>();
        result.put("id", this.id.toString());
        result.put("resource", TokenEnum.CONFIRMATION.toString());
        return result;
    }

    public int expiresAt() {
        return 60 * 60; // seconds = 15min
    }
}
