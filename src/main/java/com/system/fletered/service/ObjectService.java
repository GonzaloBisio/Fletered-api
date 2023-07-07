package com.system.fletered.service;

import com.system.fletered.dto.AttributeDto;
import com.system.fletered.dto.ObjectDto;
import com.system.fletered.dto.UsuarioDto;
import com.system.fletered.entities.Attribute;
import com.system.fletered.entities.Object;
import com.system.fletered.entities.ObjectAttribute;
import com.system.fletered.entities.Usuario;
import com.system.fletered.repository.AttributeRepository;
import com.system.fletered.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectService {

    @Autowired
    private AttributeRepository attributeRepository;

    private final ObjectRepository objectRepository;

    public ObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public Object createObject(ObjectDto createObjectRequest) {
        List<ObjectAttribute> attributes = new ArrayList<>();

        Object newObj = Object.builder()
                .palet(createObjectRequest.getPalet())
                .name(createObjectRequest.getName())
                .largo(createObjectRequest.getLargo())
                .ancho(createObjectRequest.getAncho())
                .profundo(createObjectRequest.getProfundo())
                .medidasGral(createObjectRequest.getMedidasGral())
                .build();

        // Create ObjectAttribute entities for each attribute in the request
        for (AttributeDto attributeDto : createObjectRequest.getAttributes()) {
            Attribute attribute = null;
            try {
                attribute = attributeRepository.findById(attributeDto.getId())
                        .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            } catch (ChangeSetPersister.NotFoundException e) {
                throw new RuntimeException(e);
            }

            ObjectAttribute objectAttribute = ObjectAttribute.builder()
                    .object(newObj)
                    .attribute(attribute)
                    .value(attributeDto.getValue())
                    .build();

            attributes.add(objectAttribute);
        }

        newObj.setAttributes(attributes);

        return objectRepository.save(newObj);
    }
}
