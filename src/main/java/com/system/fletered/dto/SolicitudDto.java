package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.system.fletered.entities.Solicitud}
 */
@Value
public class SolicitudDto implements Serializable {
    Long id;
    String dni;
    String name;
    String lastName;
    String email;
    String phoneNumber;
    String street;
    String streetNumber;


}