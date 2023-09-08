package com.system.fletered.controller;

import com.system.fletered.dto.SolicitudDto;
import com.system.fletered.entities.Solicitud;
import com.system.fletered.service.SolicitudService;
import com.system.fletered.utils.Tools;
import com.system.fletered.utils.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/solicitud")
@Slf4j
@RestController
public class SolicitudController {
    private static Logger logger = LoggerFactory.getLogger(SolicitudController.class);

    @Autowired
    private Tools tools;

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/all")
    public List<Solicitud> solicitudes() {
        return solicitudService.getAllSolicitudes();
    }

    @PostMapping()
    public ResponseEntity<Object> createSolicitud(@RequestBody SolicitudDto createSolicitudRequest) {
        try {
            // Create Solicitud with associated Carga instances
            Solicitud solicitud = solicitudService.createSolicitudWithCargas(createSolicitudRequest);

            if (solicitud != null) {
                return tools.ok(solicitud);
            } else {
                return tools.error("Failed to create Solicitud");
            }
        } catch (Exceptions e) {
            logger.error(e.getMessage());
            return tools.error(e.getMessage(), e.getHttpStatus());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return tools.error(ex.getMessage());
        }
    }
}