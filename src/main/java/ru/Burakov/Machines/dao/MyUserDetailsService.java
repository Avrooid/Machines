package ru.Burakov.Machines.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.models.userInfo.MyUser;
import ru.Burakov.Machines.models.userInfo.MyUserDetails;
import ru.Burakov.Machines.repositories.MyUserRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Can't find user with this username");
        return new MyUserDetails(user);
    }
}
