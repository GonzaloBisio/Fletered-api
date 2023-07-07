package com.system.fletered.controller;

import com.system.fletered.dto.ObjectDto;
import com.system.fletered.service.ObjectService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RestController
@RequestMapping("/objects")
public class ObjectController {

    private final ObjectService objectService;

    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @PostMapping
    public Object createObject(@RequestBody ObjectDto object) {
        return objectService.createObject(object);
    }
}