package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "conductor")
public class Conductor implements Serializable {
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

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}