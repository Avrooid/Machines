package ru.Burakov.Machines.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.models.response.AuthResponse;
import ru.Burakov.Machines.models.userInfo.MyUser;
import ru.Burakov.Machines.repositories.MyUserRepository;

import java.security.Principal;

@RequiredArgsConstructor
@Service
@Profile("dev")
public class UserInfoDevService implements UserInfo{
    private final MyUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse getRoleUser(Principal principal) {
        MyUser user = userRepository.findByUsername(principal.getName());
        return new AuthResponse(user.getUsername(), passwordEncoder.encode(user.getPassword()));
    }
}
