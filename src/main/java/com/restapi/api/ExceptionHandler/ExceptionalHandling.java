package com.restapi.api.ExceptionHandler;

import com.restapi.api.Controller.DepartmentController;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice(assignableTypes = DepartmentController.class)
public class ExceptionalHandling {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleElementNotFoundException(NoSuchElementException e){
        ErrorResponse error=ErrorResponse.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        ErrorResponse error=ErrorResponse.builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception e){
       ErrorResponse error=ErrorResponse.builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
       List<String> errors=exception.getBindingResult()
               .getAllErrors()
               .stream()
               .map(error -> error.getDefaultMessage())
               .collect(Collectors.toList());

      ErrorResponse response=ErrorResponse.
              builder().
              status(HttpStatus.NOT_ACCEPTABLE)
              .message(errors.toString()).timeStamp(LocalDateTime.now())
              .build();
        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
}

