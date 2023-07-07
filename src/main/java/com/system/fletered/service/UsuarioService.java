package com.system.fletered.service;

import java.time.LocalDateTime;
import java.util.*;

import com.system.fletered.dto.UsuarioDto;
import com.system.fletered.entities.Usuario;
import com.system.fletered.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario createUsuario(UsuarioDto createUsuarioRequest) {

        Usuario newObj = Usuario.builder()
                .creationTime(LocalDateTime.now())
                .password(createUsuarioRequest.getPassword())
                .contactPhone(createUsuarioRequest.getContactPhone())
                .email(createUsuarioRequest.getEmail())
                .name(createUsuarioRequest.getName())
                .surname(createUsuarioRequest.getSurname())
                .build();

        return this.usuarioRepository.save(newObj);
    }
}
