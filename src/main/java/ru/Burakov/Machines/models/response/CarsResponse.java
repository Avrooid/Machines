package ru.Burakov.Machines.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsResponse {
    private String carBrandName;
    private List<String> carsName;
}
