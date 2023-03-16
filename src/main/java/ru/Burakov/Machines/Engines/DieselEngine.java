package ru.Burakov.Machines.Engines;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DieselEngine implements Engine{

    @Override
    public void getInfo() {
        log.info("This is diesel engine.");
    }
}
