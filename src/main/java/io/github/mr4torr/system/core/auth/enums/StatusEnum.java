package io.github.mr4torr.system.core.auth.enums;

//import lombok.Getter;

//@Getter
public enum StatusEnum {
    ACTIVE,
    INACTIVE,
    BLOCKED;

//    private final String value;
//    StatusEnum(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return this.toString();
//    }

    public static StatusEnum _default() {
        return INACTIVE;
    }
}

