package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.MedidasGral}
 */
@Value
public class MedidasGralDto implements Serializable {
    Long id;
    ObjectDto object;
    String descripcion;
}