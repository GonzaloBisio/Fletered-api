package com.system.fletered.service;

import com.system.fletered.dto.CargaDto;
import com.system.fletered.entities.Carga;
import com.system.fletered.entities.Solicitud;
import com.system.fletered.repository.CargaRepository;
import com.system.fletered.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargaService {

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    public Carga createCargaWithSolicitud(CargaDto createCargaRequest) {
        Optional<Solicitud> solicitudOptional = this.solicitudRepository.findById(createCargaRequest.getSolicitud().getId());

        if (solicitudOptional.isPresent()) {
            Solicitud solicitud = solicitudOptional.get();

            Carga carga = Carga.builder()
                    .solicitud(solicitud)
                    .label(createCargaRequest.getLabel())
                    .medida(createCargaRequest.getMedida())
                    .build();

            // Add the carga to the solicitud's list of cargas
            solicitud.getCargas().add(carga);

            // Save the solicitud to cascade the changes to cargas
            this.solicitudRepository.save(solicitud);

            return carga;
        } else {
            System.out.println("Solicitud no encontrada");
            return null;
        }
    }

    public List<Carga> createCargas(List<Carga> cargas) {
        // Save the list of Carga entities
        return cargaRepository.saveAll(cargas);
    }

}