package ru.Burakov.Machines.models.Vehicles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.Burakov.Machines.models.Engines.ElectricEngine;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectricCar {
    private ElectricEngine engine;
    private int price;
}
