package com.system.fletered.dto;

import com.system.fletered.dto.CargaDto;
import com.system.fletered.dto.SolicitudDto;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for a request that includes SolicitudDto and a list of CargaDto objects.
 */
@Value
@Getter
@Setter
public class SolicitudWithCargasRequest implements Serializable {
    SolicitudDto solicitudDto;
    List<CargaDto> cargaDtos;
}