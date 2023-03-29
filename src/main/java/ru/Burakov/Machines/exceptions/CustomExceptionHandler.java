package ru.Burakov.Machines.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(DaoException.class)
    public ResponseEntity<ResponseError> badGateWayException(DaoException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new ResponseError(exception.getMessage()), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> validException(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage());
        List<ValidationError> errors = new ArrayList<>();
        List<FieldError> validateErrors = exception.getBindingResult().getFieldErrors();
        for (FieldError validateError : validateErrors) {
            errors.add(new ValidationError(validateError.getField(), validateError.getDefaultMessage()));
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
