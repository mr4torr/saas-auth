package io.github.mr4torr.system.core.auth.enums;

public enum TokenEnum {
    REFRESH,
    FORGOT,
    CONFIRMATION,
    AUTHORIZATION;

//    private final String value;
//
//    public String toString() {
//        return value;
//    }
//
//    TokenEnum(String value) {
//        this.value = value;
//    }

    public static TokenEnum _default() {
        return AUTHORIZATION;
    }
}
