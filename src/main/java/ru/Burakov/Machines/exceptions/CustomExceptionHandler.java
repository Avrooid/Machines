package ru.Burakov.Machines.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(DaoException.class)
    public ResponseEntity<ResponseError> badGateWayException(DaoException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new ResponseError(exception.getMessage()), HttpStatus.BAD_GATEWAY);
    }
}
