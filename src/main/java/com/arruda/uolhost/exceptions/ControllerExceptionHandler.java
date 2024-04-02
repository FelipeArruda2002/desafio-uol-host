package com.arruda.uolhost.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity threatNoSuchElementException(NoSuchElementException exception) {
        ExceptionDto exceptionDto = new ExceptionDto("Não existe mais codinomes disponíveis", 400);
        return ResponseEntity.badRequest().body(exceptionDto);
    }
}
