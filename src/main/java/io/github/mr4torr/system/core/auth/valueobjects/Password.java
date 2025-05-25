package io.github.mr4torr.system.core.auth.valueobjects;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public record Password(String password) {
    public static final int PASSWORD_LENGTH = 8;

    public Password {
//        Objects.requireNonNull(password, "null");
//        if (!isValid()) {
//            throw new IllegalArgumentException(String.join(";", errors()));
//        }
    }

    public boolean check(String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public boolean isValid() {
        return errors().isEmpty();
    }

    public List<String> errors() {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChars = password.matches(".*[^\\w].*");

        List<String> errors = new ArrayList<>();
        if (password.length() < Password.PASSWORD_LENGTH) {
            errors.add("min:" + Password.PASSWORD_LENGTH);
        }

        if (!hasUppercase) {
            errors.add("uppercase");
        }

        if (!hasLowercase) {
            errors.add("lowercase");
        }

        if (!hasNumber) {
            errors.add("number");
        }

        if (!hasSpecialChars) {
            errors.add("special");
        }

        return errors;
    }

    public static Password fromString(String password) {
        return new Password(password);
    }

    @Override
    public String toString() {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
