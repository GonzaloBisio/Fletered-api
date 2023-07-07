package com.system.fletered.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Tools {

    public Tools(){}

    public ResponseEntity<Object> error(String mensaje, HttpStatus httpStatus){
        Map<String, String> error = new HashMap<String,String>();
        error.put("error", mensaje);
        return new ResponseEntity<>(error, httpStatus);
    }

    public ResponseEntity<Object> error(String mensaje){
        Map<String, String> error = new HashMap<String,String>();
        error.put("error", mensaje);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> ok(Object entity){
        return ResponseEntity.ok(entity);
    }
}
