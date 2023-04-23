package ru.Burakov.Machines.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.models.brands.CarBrand;
import ru.Burakov.Machines.repositories.DbCarBrandRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCarBrandDAO {
    private final DbCarBrandRepository carBrandRepository;

    public CarBrand save(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }

    public List<CarBrand> getBrands() {
        return carBrandRepository.findAll();
    }
}
