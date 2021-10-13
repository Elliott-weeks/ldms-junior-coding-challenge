package com.example.challenge.utils;


import com.example.challenge.exceptions.BisectionInvalidArguments;
import com.example.challenge.responses.BisectionInvalidArgumentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalErrorHandler {

    @ExceptionHandler(BisectionInvalidArguments.class)
    public ResponseEntity<BisectionInvalidArgumentResponse> handleInvalidBisectionArgument(Exception exception, HttpServletResponse response) throws IOException {
        BisectionInvalidArgumentResponse error = new BisectionInvalidArgumentResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setError(exception.getMessage());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);

    }
}


