package com.system.fletered.service;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.system.fletered.dto.CargaDto;
import com.system.fletered.dto.SolicitudDto;
import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.entities.Carga;
import com.system.fletered.entities.Solicitud;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.CargaRepository;
import com.system.fletered.repository.SolicitudRepository;
import com.system.fletered.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private CargaService cargaService; // Inject the CargaService


    public Solicitud createSolicitudWithCargas(SolicitudDto createSolicitudRequest) {
        // Create the Solicitud entity
        Solicitud solicitud = Solicitud.builder()
                .dni(createSolicitudRequest.getDni())
                .name(createSolicitudRequest.getName())
                .lastName(createSolicitudRequest.getLastName())
                .email(createSolicitudRequest.getEmail())
                .phoneNumber(createSolicitudRequest.getPhoneNumber())
                .InitialStreet(createSolicitudRequest.getInitialStreet())
                .InitialStreetNumber(createSolicitudRequest.getInitialStreetNumber())
                .FinalStreet(createSolicitudRequest.getFinalStreet())
                .FinalStreetNumber(createSolicitudRequest.getFinalStreetNumber())
                .PeriodoInicio(createSolicitudRequest.getPeriodoInicio())
                .PeriodoFin(createSolicitudRequest.getPeriodoFin())
                .build();

        // Save the Solicitud to obtain its ID
        solicitud = this.solicitudRepository.save(solicitud);

        // Create Carga entities and associate them with the Solicitud
        List<CargaDto> cargaDtos = createSolicitudRequest.getCargas();
        List<Carga> cargas = new ArrayList<>();

        for (CargaDto cargaDto : cargaDtos) {
            Carga carga = new Carga();
            carga.setLabel(cargaDto.getLabel());
            carga.setMedida(cargaDto.getMedida());
            carga.setSolicitud(solicitud); // Associate with the Solicitud entity
            cargas.add(carga);
        }

        // Save the Carga entities
        cargaService.createCargas(cargas);

        return solicitud;
    }

    public List<Solicitud> getAllSolicitudes() {
        return solicitudRepository.findAll();
    }

}






