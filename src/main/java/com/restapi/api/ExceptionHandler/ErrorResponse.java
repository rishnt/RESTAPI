package com.restapi.api.ExceptionHandler;

import java.time.LocalDateTime;

public class ErrorResponse {
    String message;
    LocalDateTime timeStamp;
    String  status;

    public ErrorResponse(String message,String status){
        this.message=message;
        this.timeStamp= LocalDateTime.now();
        this.status=status;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

