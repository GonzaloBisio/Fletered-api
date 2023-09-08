package com.system.fletered.dto;

import com.system.fletered.entities.Solicitud;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.system.fletered.entities.Carga}
 */

@Getter
@Setter
public class CargaDto implements Serializable {
    Long id;
    String label;
    String medida;
    Integer cantidad;
    public Solicitud solicitud;
}