package com.springrest.springrest.controller;


import com.springrest.springrest.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandleController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorCode.ENTITY_NOT_FOUND);
    }
}