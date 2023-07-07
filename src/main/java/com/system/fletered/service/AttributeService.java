package com.system.fletered.service;

import java.util.List;

import com.system.fletered.dto.AttributeDto;
import com.system.fletered.dto.VehiculoDto;
import com.system.fletered.entities.Attribute;
import com.system.fletered.entities.Vehiculo;
import com.system.fletered.repository.AttributeRepository;
import com.system.fletered.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;



    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    public Attribute createAttribute(AttributeDto createAttributeRequest) {

        Attribute newObj = Attribute.builder()
                .name(createAttributeRequest.getName())
                .build();

        return this.attributeRepository.save(newObj);
    }
}
