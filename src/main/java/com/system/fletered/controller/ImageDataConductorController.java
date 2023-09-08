package com.system.fletered.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.system.fletered.service.ImageDataVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/imagenesConductor")

public class ImageDataConductorController {

    @Autowired
    private ImageDataVehiculoService service;

    @PostMapping
    public ResponseEntity<?> uploadImage(
            @RequestParam Long id,
            @RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(id, file);
        if (uploadImage != null) {
            return ResponseEntity.ok(uploadImage);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload image.");
        }
    }




    @GetMapping("/{idConductor}")
    public ResponseEntity<?> downloadImage(@PathVariable Long idConductor){
        byte[] imageData= service.downloadImages(idConductor);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

}
