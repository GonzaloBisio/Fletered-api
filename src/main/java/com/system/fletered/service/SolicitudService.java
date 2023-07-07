package com.system.fletered.service;

import java.util.List;

import com.system.fletered.dto.SolicitudDto;
import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.entities.Solicitud;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.SolicitudRepository;
import com.system.fletered.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;



    public List<Solicitud> getAllSolicitudes() {
        return solicitudRepository.findAll();
    }

    public Solicitud createSolicitud(SolicitudDto createSolicitudRequest) {

        Solicitud newObj = Solicitud.builder()
                .street(createSolicitudRequest.getStreet())
                .streetNumber(createSolicitudRequest.getStreetNumber())
                .name(createSolicitudRequest.getName())
                .lastName(createSolicitudRequest.getLastName())
                .dni(createSolicitudRequest.getDni())
                .email(createSolicitudRequest.getEmail())
                .phoneNumber(createSolicitudRequest.getPhoneNumber())
                .build();

        return this.solicitudRepository.save(newObj);
    }
}
