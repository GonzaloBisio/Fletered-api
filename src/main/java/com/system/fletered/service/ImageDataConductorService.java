package com.system.fletered.service;

import com.system.fletered.entities.Conductor;
import com.system.fletered.entities.ImageDataConductor;
import com.system.fletered.entities.ImageDataVehiculo;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.ConductorRepository;
import com.system.fletered.repository.ImageDataConductorRepository;
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
public class ImageDataConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private ImageDataConductorRepository repository;

    @Transactional
    public String uploadImage(Long idConductor, MultipartFile file) throws IOException {

        Optional<Conductor> conductor = this.conductorRepository.findById(idConductor);

        if (conductor.isPresent()) {

            ImageDataConductor imageData = repository.save(ImageDataConductor.builder()
                    .idConductor(conductor.get())
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
    public List<byte[]> downloadImages(Long id) {
        Optional<Conductor> conductor = conductorRepository.findById(id);

        List<ImageDataConductor> dbImageData = repository.findByIdConductor(conductor.get());
        List<byte[]> images = new ArrayList<>();

        for (ImageDataConductor imageData : dbImageData) {
            byte[] imageBytes = ImageUtils.decompressImage(imageData.getImagedata());
            images.add(imageBytes);
        }

        return images;
    }

    @Transactional
    public List<byte[]> getAllImageData(Long idConductor) {
        Optional<Conductor> conductor = conductorRepository.findById(idConductor);
        List<byte[]> imageDataList = new ArrayList<>();

        if (conductor.isPresent()) {
            List<ImageDataConductor> imageEntities = repository.findByIdConductor(conductor.get());

            for (ImageDataConductor imageEntity : imageEntities) {
                imageDataList.add(ImageUtils.decompressImage(imageEntity.getImagedata()));
            }
        }

        return imageDataList;
    }
}
