package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.Conductor}
 */
@Value
public class ConductorDto implements Serializable {
    Long id;
}