package ru.Burakov.Machines.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.Burakov.Machines.dao.DbCarDAO;
import ru.Burakov.Machines.models.brands.CarBrand;
import ru.Burakov.Machines.models.cars.MyCar;
import ru.Burakov.Machines.models.response.CarsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db/car")
public class DbCarController {
    private final DbCarDAO carDAO;

    @PostMapping("/add/{id}")
    private void save(@PathVariable Long id, @RequestBody List<String> names) {
        carDAO.save(id, names);
    }

    @GetMapping("/getAll")
    private List<CarsResponse> getInfo() {
        return carDAO.getInfo();
    }
}