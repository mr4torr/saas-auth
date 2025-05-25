package io.github.mr4torr.system.application.auth.usecases;

import io.github.mr4torr.system.application.auth.usecases.dtos.RegisterUserInbound;
import io.github.mr4torr.system.application.auth.usecases.dtos.UserOutbound;
import io.github.mr4torr.system.shared.exception.FieldException;

public interface RegisterUser {
    public UserOutbound make(RegisterUserInbound input) throws FieldException;
}
