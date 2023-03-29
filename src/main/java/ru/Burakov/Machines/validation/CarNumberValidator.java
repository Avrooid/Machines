package ru.Burakov.Machines.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CarNumberValidator implements ConstraintValidator<ValidateCarNumber, String> {
    @Override
    public void initialize(ValidateCarNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String carNumber, ConstraintValidatorContext constraintValidatorContext) {
        return carNumber.matches("^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$");
    }
}
