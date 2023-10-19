package com.udemy.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {

    private HttpStatus statusCode;
    private String message;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public ErrorMessage(){
    }

    public ErrorMessage(HttpStatus statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
