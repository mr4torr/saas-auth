package io.github.mr4torr.system.core.auth;

import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.core.auth.persistence.UserPersistence;
import io.github.mr4torr.system.core.auth.valueobjects.Email;
import io.github.mr4torr.system.shared.exception.BusinessException;
import io.github.mr4torr.system.shared.exception.FieldException;

public class CreateUserService {
    private final UserPersistence userPersistence;

    public CreateUserService(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public User create(String name, Email email) {
        if (!email.isValid()) {
            throw new FieldException("email", "email_invalid");
        }

        if (userPersistence.emailAlreadyExists(email)) {
            throw new FieldException("email", "duplicate");
        }

        User user = userPersistence.create(User.newInstance(name, email));
        if (user == null) {
            throw new BusinessException("error_sign_up_user");
        }

        return user;
    }
}
