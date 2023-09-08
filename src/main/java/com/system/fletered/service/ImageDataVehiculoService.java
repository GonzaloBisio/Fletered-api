package com.system.fletered.service;

import com.system.fletered.entities.ImageDataVehiculo;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.ImageDataVehiculoRepository;
import com.system.fletered.repository.VehiculoRepository;
import com.system.fletered.utils.exceptions.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ImageDataVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ImageDataVehiculoRepository repository;

    @Transactional
    public String uploadImage(Long idBaul, MultipartFile file) throws IOException {

        Optional<Vehiculo> vehiculo = this.vehiculoRepository.findById(idBaul);

        if (vehiculo.isPresent()) {

            ImageDataVehiculo imageData = repository.save(ImageDataVehiculo.builder()
                    .idVehiculo(vehiculo.get())
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .imagedata(ImageUtils.compressImage(file.getBytes())).build());
            if (imageData != null) {
                return "file uploaded successfully: " + file.getOriginalFilename();
            }
        }
        return null;

    }

    @Transactional
    public byte[] downloadImages(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);

        ImageDataVehiculo dbImageData = repository.findByIdVehiculo(vehiculo.get());
        byte[] imageBytes = ImageUtils.decompressImage(dbImageData.getImagedata());

        return imageBytes;
    }

}
