package ru.Burakov.Machines.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Burakov.Machines.models.brands.CarBrand;
import ru.Burakov.Machines.models.cars.MyCar;
import ru.Burakov.Machines.models.response.CarsResponse;
import ru.Burakov.Machines.repositories.DbCarBrandRepository;
import ru.Burakov.Machines.repositories.DbCarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCarDAO {
    private final DbCarBrandRepository carBrandRepository;
    private final DbCarRepository carRepository;
    private final RabbitProducerService rabbitMessageService;
    public void save(Long id, List<String> carsNames) {
        CarBrand carBrand = carBrandRepository.getReferenceById(id);
        for(String carName : carsNames) {
            MyCar tempCar = MyCar.builder()
                    .name(carName)
                    .carBrand(carBrand)
                    .build();
            carRepository.save(tempCar);
        }
    }

    public List<CarsResponse> getInfo() {
        List<CarBrand> brands = carBrandRepository.findAll();
        List<CarsResponse> carsResponseList = new ArrayList<>();
        for (CarBrand brand:brands) {
            List<MyCar> cars = carRepository.findAllByCarBrand(brand);
            List<String> carNames = new ArrayList<>();
            for(MyCar car:cars) {
                carNames.add(car.getName());
            }
            carsResponseList.add(new CarsResponse(brand.getName(), carNames));
        }

        return carsResponseList;
    }

    public String getPrice(String carName) {
        return rabbitMessageService.send(carName);
    }
}
