package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.system.fletered.entities.Carga}
 */
@Value
public class CargaDto implements Serializable {
    Long id;
    List<PaletDto> palets;
}