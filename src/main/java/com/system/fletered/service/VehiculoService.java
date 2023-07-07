package com.system.fletered.service;

import java.util.List;

import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;



    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo createVehiculo(VehiculoDto createVehiculoRequest) {

        Vehiculo newVehiculo = Vehiculo.builder()
                .patente(createVehiculoRequest.getPatente())
                .anio(createVehiculoRequest.getAnio())
                .color(createVehiculoRequest.getColor())
                .modelo(createVehiculoRequest.getModelo())
                .marca(createVehiculoRequest.getMarca())
                .build();

        return this.vehiculoRepository.save(newVehiculo);
    }
}
