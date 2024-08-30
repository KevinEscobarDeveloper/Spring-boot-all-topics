package com.excepciones.springboot_errors.controllers;

import com.excepciones.springboot_errors.exceptions.UserNotFoundException;
import com.excepciones.springboot_errors.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDto> divisionByZero(Exception ex){
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler (NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> notFoundEx(NoHandlerFoundException ex){
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
    @ExceptionHandler ({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    public ResponseEntity<ErrorDto> userNotFoundException(Exception ex){
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setError("Usuario o rol no existe");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler (NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> numberFormatException(NumberFormatException ex){
        Map<String,String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "Incorrect number format");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        return error;
    }

}
