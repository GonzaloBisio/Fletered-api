package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.Vehiculo}
 */
@Value
public class VehiculoDto implements Serializable {
    Long id;
    String patente;
    String marca;
    String modelo;
    Integer anio;
    String color;
}