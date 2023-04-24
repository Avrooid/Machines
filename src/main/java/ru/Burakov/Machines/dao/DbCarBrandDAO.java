package ru.Burakov.Machines.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.models.brands.CarBrand;
import ru.Burakov.Machines.models.request.BrandRequest;
import ru.Burakov.Machines.models.response.BrandResponse;
import ru.Burakov.Machines.repositories.DbCarBrandRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCarBrandDAO {
    private final DbCarBrandRepository carBrandRepository;

    public BrandResponse save(BrandRequest brandRequest) {
        CarBrand carBrand = CarBrand.builder()
                .name(brandRequest.getName())
                .build();
        carBrandRepository.save(carBrand);
        return BrandResponse.builder()
                .id(carBrand.getId())
                .name(carBrand.getName())
                .build();
    }

    public List<CarBrand> getBrands() {
        return carBrandRepository.findAll();
    }
}
