package com.restapi.api.ExceptionHandler;

import com.restapi.api.Controller.DepartmentController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice(assignableTypes = DepartmentController.class)
public class ExceptionalHandling {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleElementNotFoundException(NoSuchElementException e){
        ErrorResponse error=new ErrorResponse(e.getMessage(),"active");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        ErrorResponse response=new ErrorResponse(e.getMessage(),"active");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        ErrorResponse resp=new ErrorResponse(e.getMessage(),"the User is not Present");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
    }
}

