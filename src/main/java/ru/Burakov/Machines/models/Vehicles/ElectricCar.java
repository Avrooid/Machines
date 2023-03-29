package ru.Burakov.Machines.models.Vehicles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.Burakov.Machines.models.Engines.ElectricEngine;
import ru.Burakov.Machines.validation.ValidateCarNumber;
import ru.Burakov.Machines.validation.ValidateCarPrice;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectricCar {
    private String name;
    private ElectricEngine engine;
    @ValidateCarPrice
    private int price;
    @ValidateCarNumber
    private String carNumber;
}
