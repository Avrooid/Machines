package ru.Burakov.Machines.Vehicles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.Burakov.Machines.Engines.Engine;

@Component
@Slf4j
public class DieselCar {
    private Engine engine;

    @PostConstruct
    public void postConstruct(){
        log.info("Diesel car bean created.");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("Diesel car bean deleted.");
    }

    @Autowired
    public void setEngine(@Qualifier("dieselEngine") Engine engine) {
        this.engine = engine;
    }
}
