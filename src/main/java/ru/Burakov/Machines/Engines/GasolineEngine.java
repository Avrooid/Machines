package ru.Burakov.Machines.Engines;

import org.springframework.stereotype.Component;

@Component
public class GasolineEngine implements Engine {

    @Override
    public void getInfo() {
        System.out.println("This is gas engine.");
    }
}
