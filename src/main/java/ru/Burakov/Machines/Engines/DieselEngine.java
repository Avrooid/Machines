package ru.Burakov.Machines.Engines;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine{

    @Override
    public void getInfo() {
        System.out.println("This is diesel engine.");
    }
}
