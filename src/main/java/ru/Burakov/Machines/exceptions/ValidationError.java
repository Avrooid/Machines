package ru.Burakov.Machines.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationError {
    private String fieldName;
    private String message;
}
