package ru.Burakov.Machines.models.Engines;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectricEngine {
    private String name;
    private int volume;
    private int id;
}
