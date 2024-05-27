package com.example.verificaData.exception;


import com.example.verificaData.exception.exdipendenti.AggiuntaDipendenteException;
import com.example.verificaData.exception.exdipendenti.DipendenteNotFoundException;
import com.example.verificaData.exception.exlaptop.LaptopAlreadyAssignedException;
import com.example.verificaData.exception.exlaptop.LaptopAlreadyExistsException;
import com.example.verificaData.exception.exlaptop.LaptopNotFoundException;
import com.example.verificaData.exception.exsmartphone.SmartphoneAlreadyAssignedException;
import com.example.verificaData.exception.exsmartphone.SmartphoneAlreadyExistsException;
import com.example.verificaData.exception.exsmartphone.SmartphoneNotFoundException;
import com.example.verificaData.exception.extablet.TabletAlreadyAssignedException;
import com.example.verificaData.exception.extablet.TabletAlreadyExistsException;
import com.example.verificaData.exception.extablet.TabletNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Si è verificato un errore interno nel server.");
    }

    @ExceptionHandler({AggiuntaDipendenteException.class, DipendenteNotFoundException.class})
    public ResponseEntity<String> handleCustomException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }



    @ExceptionHandler(LaptopAlreadyExistsException.class)
    public ResponseEntity<String> handleLaptopAlreadyExistsException(LaptopAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(LaptopNotFoundException.class)
    public ResponseEntity<String> handleLaptopNotFoundException(LaptopNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(LaptopAlreadyAssignedException.class)
    public ResponseEntity<String> handleLaptopAlreadyAssignedException(LaptopAlreadyAssignedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    // smartphone



    @ExceptionHandler(SmartphoneNotFoundException.class)
    public ResponseEntity<String> handleSmartphoneNotFoundException(SmartphoneNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(SmartphoneAlreadyAssignedException.class)
    public ResponseEntity<String> handleSmartphoneAlreadyAssignedException(SmartphoneAlreadyAssignedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler(SmartphoneAlreadyExistsException.class)
    public ResponseEntity<String> handleSmartphoneAlreadyExistsException(SmartphoneAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }



    //tablet


    @ExceptionHandler(TabletAlreadyExistsException.class)
    public ResponseEntity<String> handleTabletAlreadyExistsException(TabletAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TabletNotFoundException.class)
    public ResponseEntity<String> handleTabletNotFoundException(TabletNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TabletAlreadyAssignedException.class)
    public ResponseEntity<String> handleTabletAlreadyAssignedException(TabletAlreadyAssignedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        List<ObjectError> errorsList = ex.getErrorsList();
        List<String> errorMessages = errorsList.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorMessages);
    }



}
