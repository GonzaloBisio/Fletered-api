package com.system.fletered.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.system.fletered.entities.Usuario}
 */
@Value
public class UsuarioDto implements Serializable {
    Long id;
    String password;

    String name;
    String surname;
    String email;
    String contactPhone;
    LocalDateTime creationTime;
    String token;
}