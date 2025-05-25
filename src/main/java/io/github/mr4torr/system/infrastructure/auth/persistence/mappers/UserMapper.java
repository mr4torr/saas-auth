package io.github.mr4torr.system.infrastructure.auth.persistence.mappers;


import io.github.mr4torr.system.core.auth.entities.User;
import io.github.mr4torr.system.infrastructure.auth.persistence.UserJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User modelJpaToEntity(UserJpa resource);

    UserJpa entityToModelJpa(User resource);
}
