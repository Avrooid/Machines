package ru.Burakov.Machines.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
@Min(1)
@Max(5000000)
public @interface ValidateCarPrice {
    public String message() default "Invalid car name: name must be at least 2 and no more than 20 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
