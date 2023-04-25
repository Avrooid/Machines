package ru.Burakov.Machines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.Machines.models.userInfo.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
