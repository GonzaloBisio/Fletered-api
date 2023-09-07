package com.system.fletered.controller;

import com.system.fletered.dto.CargaDto;
import com.system.fletered.dto.SolicitudDto;
import com.system.fletered.entities.Solicitud;
import com.system.fletered.repository.SolicitudRepository;
import com.system.fletered.service.CargaService;
import com.system.fletered.service.SolicitudService;
import com.system.fletered.utils.Tools;
import com.system.fletered.utils.exceptions.generic.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/carga")
@Slf4j
@RestController
public class CargaController {

        private static Logger logger = LoggerFactory.getLogger(VehiculoController.class);

        @Autowired
        private Tools tools;

        @Autowired
        private SolicitudRepository solicitudRepository;

        @Autowired
        private CargaService cargaService;



        @PostMapping()
        public ResponseEntity<Object> createCarga(@RequestBody CargaDto createCargaRequest) {
            try {
                return tools.ok(this.cargaService.createCargaWithSolicitud(createCargaRequest));
            } catch (Exceptions e) {
                logger.error(e.getMessage());
                return tools.error(e.getMessage(), e.getHttpStatus());
            } catch (Exception ex) {
                logger.error(ex.getMessage());
                return tools.error(ex.getMessage());
            }
        }


    }
