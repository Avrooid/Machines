package ru.Burakov.Machines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.Machines.models.brands.CarBrand;
import ru.Burakov.Machines.models.cars.MyCar;

import java.util.List;

public interface DbCarRepository extends JpaRepository<MyCar, Long> {
    List<MyCar> findAllByCarBrand(CarBrand carBrand);
}
