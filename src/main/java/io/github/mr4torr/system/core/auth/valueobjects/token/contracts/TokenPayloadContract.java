package io.github.mr4torr.system.core.auth.valueobjects.token.contracts;

import java.util.Map;

public interface TokenPayloadContract {
    Map<String, String> toArray();

    int expiresAt();
}

