package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.MedidasObj}
 */
@Value
public class MedidasObjDto implements Serializable {
    Long id;
    ObjectDto object;
    Double ancho;
    Double largo;
    Double profundo;
}