package ru.Burakov.Machines.models.cars;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.Burakov.Machines.models.brands.CarBrand;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MyCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "CARBRAND_ID")
    private CarBrand carBrand;
}
