package com.system.fletered.repository;

import com.system.fletered.entities.ImageDataVehiculo;
import com.system.fletered.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDataVehiculoRepository extends JpaRepository<ImageDataVehiculo, Long> {
    ImageDataVehiculo findByIdVehiculo(Vehiculo vehiculo);
}