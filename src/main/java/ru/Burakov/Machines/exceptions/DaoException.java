package ru.Burakov.Machines.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
