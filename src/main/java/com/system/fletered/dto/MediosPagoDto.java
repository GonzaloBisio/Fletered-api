package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.MediosPago}
 */
@Value
public class MediosPagoDto implements Serializable {
    Long id;
    String descripcion;
}