package io.github.mr4torr.system.application.auth.usecases;

import io.github.mr4torr.system.shared.exception.FieldException;
import io.github.mr4torr.system.shared.exception.BusinessException;
import io.github.mr4torr.system.application.auth.usecases.dtos.UserOutbound;
import io.github.mr4torr.system.application.auth.usecases.dtos.RegisterUserInbound;
import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.core.auth.CreateUserService;
import io.github.mr4torr.system.core.auth.CreateCredentialService;
import io.github.mr4torr.system.core.auth.persistence.UserPersistence;

import java.util.Objects;

public class RegisterUserImpl implements RegisterUser {
    private final CreateUserService createUserService;
    private final CreateCredentialService createCredentialService;
    private final UserPersistence userPersistence;
    ;

    public RegisterUserImpl(
        CreateUserService createUserService,
        CreateCredentialService createCredentialService,
        UserPersistence userPersistence
    ) {
        this.createUserService = createUserService;
        this.createCredentialService = createCredentialService;
        this.userPersistence = userPersistence;
    }

    @Override
    public UserOutbound make(RegisterUserInbound input) throws FieldException
    {
        Objects.requireNonNull(input, "Object RegisterUserDtoInput not null");

        if (!input.credential().password().isValid()) {
            throw new FieldException("password", "password_invalid");
        }

        if (!input.credential().passwordConfirmation().isValid()) {
            throw new FieldException("passwordConfirmation", "password_invalid");
        }

        if (!input.credential().password().equals(input.credential().passwordConfirmation())) {
            throw new FieldException("password", "password_not_match");
        }

        User user = createUserService.create(
            input.user().name(),
            input.user().email()
        );

        try {
            createCredentialService.make(
                user.id,
                input.credential().password()
            );
        } catch (BusinessException e) {
             userPersistence.remove(user.id);
            throw e;
        }

        return new UserOutbound(
            user.id,
            user.name,
            user.email,
            user.status,
            user.reasonStatus,
            user.emailVerifiedAt,
            user.createdAt,
            user.updatedAt
        );
    }
}
