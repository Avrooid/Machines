package ru.Burakov.Machines.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.Burakov.Machines.dao.DbCarBrandDAO;
import ru.Burakov.Machines.models.brands.CarBrand;
import ru.Burakov.Machines.models.request.BrandRequest;
import ru.Burakov.Machines.models.response.BrandResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db/carBrand")
public class DbCarBrandController {
    private final DbCarBrandDAO carBrandDAO;

    @PostMapping("/add")
    public BrandResponse saveBrand(@RequestBody @Valid BrandRequest brandRequest) {
        return carBrandDAO.save(brandRequest);
    }

    @GetMapping
    public List<CarBrand> getBrands() {
        return carBrandDAO.getBrands();
    }
}
