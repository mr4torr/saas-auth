package io.github.mr4torr.system.core.auth.enums;

public enum StatusEnum {
    ACTIVE,
    INACTIVE,
    BLOCKED;

    public static StatusEnum _default() {
        return INACTIVE;
    }
}

