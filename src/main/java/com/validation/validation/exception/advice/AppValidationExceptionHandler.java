package com.validation.validation.exception.advice;

import com.validation.validation.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AppValidationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){

        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(e->e.getField(),e->e.getDefaultMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleEmptyResults(UserNotFoundException ex){
        Map<String, String> errors = new HashMap<>();
        //List<String> errors = new ArrayList<>();
        errors.put("errorMessages",ex.getMessage());
        return errors;
    }
}
