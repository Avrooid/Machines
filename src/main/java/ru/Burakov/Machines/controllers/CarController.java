package ru.Burakov.Machines.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
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


    @PostMapping("/add")
    public ElectricCar addCarAndReturn(@Valid @RequestBody ElectricCar electricCar) {
        return electricCars.addCar(electricCar);
    }
}
