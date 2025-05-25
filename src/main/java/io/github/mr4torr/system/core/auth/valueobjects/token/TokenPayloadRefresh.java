package io.github.mr4torr.system.core.auth.valueobjects.token;

import io.github.mr4torr.system.core.auth.enums.TokenEnum;
import io.github.mr4torr.system.core.auth.valueobjects.token.contracts.TokenPayloadContract;

import java.util.HashMap;
import java.util.Map;

public class TokenPayloadRefresh implements TokenPayloadContract {
    private final String id;
    private final String sessionId;

    public TokenPayloadRefresh(String id, String sessionId) {
        this.id = id;
        this.sessionId = sessionId;
    }

    public Map<String, String> toArray() {
        Map<String, String> results = new HashMap<>();
        results.put("id", this.id);
        results.put("session_id", this.sessionId);
        results.put("resource", TokenEnum.REFRESH.toString());
        return results;
    }

    public int expiresAt() {
        return 24 * 60 * 60; // seconds = 1 dia
    }
}
