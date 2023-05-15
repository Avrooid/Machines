package ru.Burakov.Machines.controllers;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.Burakov.Machines.dao.MyUserService;
import ru.Burakov.Machines.models.request.RegisterRequest;
import ru.Burakov.Machines.models.response.AuthResponse;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final MyUserService userService;

    @PostMapping("/registration")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }
}
