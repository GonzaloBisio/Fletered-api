package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conductor")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo")
    private Vehiculo vehiculo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medioPago")
    private MediosPago mediosPago;

    @Column(name = "dni",nullable = false)
    private String dni;

}