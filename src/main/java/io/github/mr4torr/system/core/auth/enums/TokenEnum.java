package io.github.mr4torr.system.core.auth.enums;

public enum TokenEnum {
    REFRESH,
    FORGOT,
    CONFIRMATION,
    AUTHORIZATION;

    public static TokenEnum _default() {
        return AUTHORIZATION;
    }
}
