package ru.Burakov.Machines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.Machines.models.brands.CarBrand;

public interface DbCarBrandRepository extends JpaRepository<CarBrand, Long> {
}
