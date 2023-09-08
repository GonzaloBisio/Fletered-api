package com.system.fletered.dto;

import com.system.fletered.entities.Carga;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * DTO for {@link com.system.fletered.entities.Solicitud}
 */
@Getter
@Setter
public class SolicitudDto implements Serializable {
    Long id;
    String dni;
    String name;
    String lastName;
    String email;
    String phoneNumber;
    String PeriodoInicio1;
    String PeriodoInicio2;
    String PeriodoFin1;
    String PeriodoFin2;
    String initialStreet;
    String finalStreet;


    public List<CargaDto> cargas;
}
