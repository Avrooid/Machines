package ru.Burakov.Machines.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.Burakov.Machines.models.userInfo.MyUser;


@Getter
public class UsersEvent extends ApplicationEvent {
    private final MyUser user;

    public UsersEvent(Object source, MyUser user) {
        super(source);
        this.user = user;
    }

}
