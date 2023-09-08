package com.system.fletered.controller;

import com.system.fletered.dto.MedidasGralDto;
import com.system.fletered.repository.MedidasGralRepository;
import com.system.fletered.service.MedidasGralService;
import com.system.fletered.utils.Tools;
import com.system.fletered.utils.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/medidasGral")
@Slf4j
@RestController
public class MedidasGralController {
    private static Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @Autowired
    private Tools tools;

    @Autowired
    private MedidasGralRepository medidasGralRepository;

    @Autowired
    private MedidasGralService medidasGralService;

    @PostMapping()
    public ResponseEntity<Object> createMedidasGral(@RequestBody MedidasGralDto createMedidasGralRequest) {
        try {
            return tools.ok(this.medidasGralService.createMedidaGral(createMedidasGralRequest));
        } catch (Exceptions e) {
            logger.error(e.getMessage());
            return tools.error(e.getMessage(), e.getHttpStatus());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return tools.error(ex.getMessage());
        }
    }



}
