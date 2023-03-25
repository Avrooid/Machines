package ru.Burakov.Machines.dao;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.exceptions.DaoException;
import ru.Burakov.Machines.models.Engines.ElectricEngine;
import ru.Burakov.Machines.models.Vehicles.ElectricCar;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectricCarDAO {
    private List<ElectricCar> electricCars = new ArrayList<>();
    private int id = 0;

    public List<ElectricCar> getCars() {
        return electricCars;
    }

    public ElectricCar getCarByEngineId(int id) {
        return electricCars.stream().
                filter(electricCar-> electricCar.getEngine().getId() == id).
                findAny().
                orElseThrow(() -> new DaoException("Машина с таким id не найдена."));
    }

    public synchronized ElectricCar addCar(ElectricCar electricCar) {
        ElectricEngine electricEngine = electricCar.getEngine();
        electricEngine.setId(++id);
        electricCars.add(electricCar);
        return electricCar;
    }
}
