package ru.Burakov.Machines.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.Burakov.Machines.dao.DbCarBrandDAO;
import ru.Burakov.Machines.models.brands.CarBrand;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db/carBrand")
public class DbCarBrandController {
    private final DbCarBrandDAO carBrandDAO;

    @PostMapping("/add")
    public CarBrand saveBrand(@RequestBody CarBrand carBrand) {
        return carBrandDAO.save(carBrand);
    }

    @GetMapping
    public List<CarBrand> getBrands() {
        return carBrandDAO.getBrands();
    }
}
