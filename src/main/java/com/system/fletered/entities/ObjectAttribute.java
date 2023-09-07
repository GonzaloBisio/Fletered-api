package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "object_attribute")
public class ObjectAttribute implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "objectId")
    private Object object;

    @ManyToOne
    @JoinColumn(name = "attributeId")
    private Attribute attribute;

    @Column(name = "value")
    private String value;

}