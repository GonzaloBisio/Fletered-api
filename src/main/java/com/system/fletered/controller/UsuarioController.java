package com.system.fletered.controller;

import com.system.fletered.dto.UsuarioDto;
import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.entities.Usuario;
import com.system.fletered.exceptions.DuplicateEmailException;
import com.system.fletered.repository.UsuarioRepository;
import com.system.fletered.repository.VehiculoRepository;
import com.system.fletered.service.UsuarioService;
import com.system.fletered.service.VehiculoService;
import com.system.fletered.utils.Tools;
import com.system.fletered.utils.exceptions.generic.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
@Slf4j
@RestController
public class UsuarioController {
    private static Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @Autowired
    private Tools tools;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Object> createUsuario(@RequestBody UsuarioDto createUsuarioRequest) {
        // Check if the email already exists in the database
        if (usuarioService.existsByEmail(createUsuarioRequest.getEmail())) {
            throw new DuplicateEmailException("Email is already registered.");
        }

        try {
            return tools.ok(this.usuarioService.createUsuario(createUsuarioRequest));
        } catch (Exceptions e) {
            logger.error(e.getMessage());
            return tools.error(e.getMessage(), e.getHttpStatus());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return tools.error(ex.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Usuario getUser(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping("/all")
    public List<Usuario> getUsers(){
        return usuarioRepository.findAll();
    }



}
