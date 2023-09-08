package com.system.fletered.controller;

import com.system.fletered.dto.AttributeDto;
import com.system.fletered.repository.AttributeRepository;
import com.system.fletered.service.AttributeService;
import com.system.fletered.utils.Tools;
import com.system.fletered.utils.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/attribute")
@Slf4j
@RestController
public class AttributeController {
    private static Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @Autowired
    private Tools tools;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeService attributeService;

    @PostMapping()
    public ResponseEntity<Object> createAttribute(@RequestBody AttributeDto createAttributeRequest) {
        try {
            return tools.ok(this.attributeService.createAttribute(createAttributeRequest));
        } catch (Exceptions e) {
            logger.error(e.getMessage());
            return tools.error(e.getMessage(), e.getHttpStatus());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return tools.error(ex.getMessage());
        }
    }



}
