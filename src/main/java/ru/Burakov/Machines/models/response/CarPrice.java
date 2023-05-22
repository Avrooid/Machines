package ru.Burakov.Machines.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPrice {
    private String carName;
    private String price;
}
