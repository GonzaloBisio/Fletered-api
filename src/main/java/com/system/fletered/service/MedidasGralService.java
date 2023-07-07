package com.system.fletered.service;

import java.util.List;

import com.system.fletered.dto.AttributeDto;
import com.system.fletered.dto.MedidasGralDto;
import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.entities.Attribute;
import com.system.fletered.entities.MedidasGral;
import com.system.fletered.entities.MedidasObj;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.AttributeRepository;
import com.system.fletered.repository.MedidasGralRepository;
import com.system.fletered.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MedidasGralService {

    @Autowired
    private MedidasGralRepository medidasGralRepository;

    public MedidasGral createMedidaGral(MedidasGralDto createMedidaGralRequest) {

        MedidasGral newObj = MedidasGral.builder()
                .descripcion(createMedidaGralRequest.getDescripcion())
                .build();

        return this.medidasGralRepository.save(newObj);
    }
}
