package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "object")
public class Object implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "palet_id", nullable = true)
    private Palet palet;

    @Column(name = "ancho")
    private Double ancho;

    @Column(name = "largo")
    private Double largo;

    @Column(name = "profundo")
    private Double profundo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medidas_gral_id")
    private MedidasGral medidasGral;

    @OneToMany(mappedBy = "object")
    private List<ObjectAttribute> attributes;


    @Column(name = "name")
    private String name;


}