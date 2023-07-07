package com.system.fletered.controller;

import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.repository.VehiculoRepository;
import com.system.fletered.service.VehiculoService;
import com.system.fletered.utils.Tools;
import com.system.fletered.utils.exceptions.generic.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/vehiculos")
@Slf4j
@RestController
public class VehiculoController {
    private static Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @Autowired
    private Tools tools;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping()
    public ResponseEntity<Object> createVehiculo(@RequestBody VehiculoDto createVehiculoRequest) {
        try {
            return tools.ok(this.vehiculoService.createVehiculo(createVehiculoRequest));
        } catch (Exceptions e) {
            logger.error(e.getMessage());
            return tools.error(e.getMessage(), e.getHttpStatus());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return tools.error(ex.getMessage());
        }
    }



}
