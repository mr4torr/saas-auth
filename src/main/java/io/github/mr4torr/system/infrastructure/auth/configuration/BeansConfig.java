package io.github.mr4torr.system.infrastructure.auth.configuration;

import io.github.mr4torr.system.application.auth.usecases.RegisterUser;
import io.github.mr4torr.system.application.auth.usecases.RegisterUserImpl;
import io.github.mr4torr.system.core.auth.CreateCredentialService;
import io.github.mr4torr.system.core.auth.CreateUserService;
import io.github.mr4torr.system.core.auth.persistence.CredentialPersistence;
import io.github.mr4torr.system.core.auth.persistence.UserPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public RegisterUser registerUser(UserPersistence userPersistence, CredentialPersistence createCredentialService) {
        return new RegisterUserImpl(
            new CreateUserService(userPersistence),
            new CreateCredentialService(createCredentialService),
            userPersistence
        );
    }
}
