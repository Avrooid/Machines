package ru.Burakov.Machines.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.Burakov.Machines.dao.ElectricCarDAO;
import ru.Burakov.Machines.models.Vehicles.ElectricCar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final ElectricCarDAO electricCars;

    @GetMapping
    public List<ElectricCar> getAllCars() {
        return electricCars.getCars();
    }

    @GetMapping("/{id}")
    public ElectricCar getCarByEngineId(@PathVariable int id) {
        return electricCars.getCarByEngineId(id);
    }

    @GetMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        Map<String, String> map = new HashMap<>();

        headers.forEach((key, value) -> {
            map.put(key, String.join("|", value));
        });

        return map;
    }

    @PostMapping("/add")
    public ElectricCar addCarAndReturn(@RequestBody ElectricCar electricCar) {
        return electricCars.addCar(electricCar);
    }
}
