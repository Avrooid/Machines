package ru.Burakov.Machines.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.Burakov.Machines.dao.MyUserService;
import ru.Burakov.Machines.dao.UserInfo;
import ru.Burakov.Machines.models.response.AuthResponse;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TechnicalInfoController {
    private final UserInfo userInfo;

    @GetMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        Map<String, String> map = new HashMap<>();

        headers.forEach((key, value) -> {
            map.put(key, String.join("|", value));
        });

        return map;
    }

    @GetMapping("/user/api")
    public AuthResponse getUserWithRoleUser(Principal principal) {
        return userInfo.getRoleUser(principal);
    }

    @GetMapping("/admin/api")
    public AuthResponse getUserWithRoleAdmin(Principal principal) {
        return userInfo.getRoleUser(principal);
    }
}
