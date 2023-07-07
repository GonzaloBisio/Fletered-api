package com.system.fletered.dto;

import com.system.fletered.entities.MedidasGral;
import com.system.fletered.entities.MedidasObj;
import com.system.fletered.entities.Palet;
import jakarta.persistence.Column;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.Object}
 */
@Value
public class ObjectDto implements Serializable {
    Long id;
    Palet palet;
    Double ancho;
    Double largo;
    Double profundo;
    MedidasGral medidasGral;
    String name;
    AttributeDto[] attributes;
}