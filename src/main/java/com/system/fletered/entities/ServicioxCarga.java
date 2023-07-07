package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "serviciox_carga")
public class ServicioxCarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carga")
    private Carga carga;

    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

}