package com.system.fletered.repository;

import com.system.fletered.entities.Conductor;
import com.system.fletered.entities.ImageDataConductor;
import com.system.fletered.entities.ImageDataVehiculo;
import com.system.fletered.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDataConductorRepository extends JpaRepository<ImageDataConductor, Long> {
    List<ImageDataConductor> findByIdConductor(Conductor conductor);
}