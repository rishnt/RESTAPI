package com.restapi.api.ExceptionHandler;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

 @Data @Builder
public class ErrorResponse {
   private HttpStatus status;
   private String message;
   private LocalDateTime timeStamp;
}

