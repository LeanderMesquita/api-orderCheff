package com.llm.orderCheff.exceptions;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleMethodNotValidException(MethodArgumentNotValidException e){
        List<ErrorResponse> errorList = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach(err -> {
            String invalidValue = ((FieldError) err).getField();
            errorList.add(new ErrorResponse(invalidValue, err.getDefaultMessage()));
        });

        return new ResponseEntity<>(errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageException(HttpMessageNotReadableException e){
        String fieldname = "Error";
        String errMessage = "Invalid Request";
        if (e.getMostSpecificCause() instanceof InvalidFormatException err){
            fieldname = err.getPath().getFirst().getFieldName();
            errMessage = "Invalid value: "+err.getValue();
        }
        return new ResponseEntity<>(new ErrorResponse(fieldname, errMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e){
        return new ResponseEntity<>(new ErrorResponse("Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e){
        return new ResponseEntity<>(new ErrorResponse("Internal error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>(new ErrorResponse("Invalid argument", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
