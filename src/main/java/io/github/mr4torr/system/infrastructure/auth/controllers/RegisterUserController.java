package io.github.mr4torr.system.infrastructure.auth.controllers;

import io.github.mr4torr.system.application.auth.usecases.RegisterUser;
import io.github.mr4torr.system.application.auth.usecases.dtos.RegisterUserInbound;
import io.github.mr4torr.system.application.auth.usecases.dtos.UserOutbound;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/register")
@AllArgsConstructor
public class RegisterUserController {
    private final RegisterUser registerUser;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserOutbound> create(@RequestBody RegisterUserInbound resource) throws Exception {
        return ResponseEntity.ok(this.registerUser.make(resource));
    }
}
