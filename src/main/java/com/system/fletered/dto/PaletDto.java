package com.system.fletered.dto;

import com.system.fletered.entities.Carga;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.system.fletered.entities.Palet}
 */
@Value
public class PaletDto implements Serializable {
    Long id;
    List<ObjectDto> objects;
    Carga carga;
    Double peso;
}