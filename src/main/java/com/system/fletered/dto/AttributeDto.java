package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.Attribute}
 */
@Value
public class AttributeDto implements Serializable {
    Long id;
    String name;
    String value;

}