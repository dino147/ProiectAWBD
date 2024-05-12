package com.dino14.proiectpwj.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleIdNotFound(RuntimeException e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleFieldValidation(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getAllErrors().stream().map(ex -> ex.getDefaultMessage()).toList();
        return ResponseEntity.badRequest()
                .body(errors);
    }

}
