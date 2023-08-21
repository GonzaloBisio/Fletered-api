package com.system.fletered.service;

import java.time.LocalDateTime;
import java.util.List;

import com.system.fletered.dto.UsuarioDto;
import com.system.fletered.entities.Usuario;
import com.system.fletered.exceptions.DuplicateEmailException;
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
        // Check if the email already exists in the database
        if (existsByEmail(createUsuarioRequest.getEmail())) {
            // You can throw a custom exception here or handle it as needed.
            throw new DuplicateEmailException("Email is already registered.");
        }

        Usuario newObj = Usuario.builder()
                .creationTime(LocalDateTime.now())
                .password(createUsuarioRequest.getPassword())
                .contactPhone(createUsuarioRequest.getContactPhone())
                .email(createUsuarioRequest.getEmail())
                .name(createUsuarioRequest.getName())
                .surname(createUsuarioRequest.getSurname())
                .firebaseId(createUsuarioRequest.getFirebaseId())
                .dni(createUsuarioRequest.getDni())
                .build();

        return this.usuarioRepository.save(newObj);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
