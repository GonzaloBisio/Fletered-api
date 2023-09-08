package com.system.fletered.utils.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class Exceptions extends RuntimeException {
    private HttpStatus httpStatus;

    public Exceptions(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

}
