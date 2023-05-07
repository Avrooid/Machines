package ru.Burakov.Machines.models.userInfo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    ADMIN("admin", "ROLE_ADMIN"),
    USER("user", "ROLE_USER");

    private final String id;
    private final String roleName;
}
