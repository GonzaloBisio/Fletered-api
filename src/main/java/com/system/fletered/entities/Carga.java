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
@Table(name = "carga")
public class Carga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "medida")
    private String medida;

    @Column(name = "cantidad")
    private Integer cantidad;


    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;
}