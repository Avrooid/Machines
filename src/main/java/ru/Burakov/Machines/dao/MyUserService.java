package ru.Burakov.Machines.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.models.request.RegisterRequest;
import ru.Burakov.Machines.models.response.AuthResponse;
import ru.Burakov.Machines.models.userInfo.MyUser;
import ru.Burakov.Machines.models.userInfo.Role;
import ru.Burakov.Machines.repositories.MyUserRepository;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        MyUser user = MyUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.USER))
                .enabled(true)
                .build();
        userRepository.save(user);
        return new AuthResponse(user.getUsername(), user.getPassword());
    }
}
