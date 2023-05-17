package ru.Burakov.Machines.dao;

import ru.Burakov.Machines.models.response.AuthResponse;

import java.security.Principal;

public interface UserInfo {
    AuthResponse getRoleUser(Principal principal);
}
