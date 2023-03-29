package ru.Burakov.Machines.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CarNumberValidator.class)
public @interface ValidateCarNumber {
    public String message() default "Invalid car number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
