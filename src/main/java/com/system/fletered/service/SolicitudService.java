package com.system.fletered.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
                .PeriodoInicio1(createSolicitudRequest.getPeriodoInicio1())
                .PeriodoInicio2(createSolicitudRequest.getPeriodoInicio2())
                .PeriodoFin1(createSolicitudRequest.getPeriodoFin1())
                .PeriodoFin2(createSolicitudRequest.getPeriodoFin2())
                .InitialStreet(createSolicitudRequest.getInitialStreet())
                .FinalStreet(createSolicitudRequest.getFinalStreet())
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
            carga.setCantidad(cargaDto.getCantidad());
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

    public Date Format(String dateString) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)", Locale.US);
        Date date = new Date();

        date.parse(dateString);
        System.out.println(date); // Prints the parsed date in the original format

        // Convert to yyyy-MM-dd format
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = outputFormat.format(date);
        System.out.println(formattedDate); // Prints the date in yyyy-MM-dd format
        return date;
    }

}






