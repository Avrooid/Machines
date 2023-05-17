package ru.Burakov.Machines.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class UsersEventListener {
    /*
        Listener записывает в текстовый файл всех зарегистрированных пользователей для удобного
        доступа к этой информации без необходимости обращения к бд за этими данными
     */
    @EventListener
    public void handleUsersEvent(UsersEvent event) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/users.txt", true))) {
            String tempUser = event.getUser().getId().toString() + " " + event.getUser().getUsername() + " " + event.getUser().getPassword() + "\n";
            bufferedWriter.write(tempUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
