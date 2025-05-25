package io.github.mr4torr.system.core.auth.valueobjects;

import java.io.Serializable;
import java.util.Objects;

public record Email(String value) {
    public Email {
        Objects.requireNonNull(value, "Email not null");
        if (!isValid(value)) {
            throw new IllegalArgumentException("E-mail inválido: " + value);
        }
    }

    public boolean isValid() {
        return isValid(this.value);
    }

    private static boolean isValid(String email) {
        return email.matches("^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static Email fromString(String value) {
        return new Email(value);
    }

    @Override
    public String toString() {
        return value;
    }
}