package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dni", length = 8)
    private String dni;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;


    @Column(name = "periodo_inicio1")
    private String PeriodoInicio1;

    @Column(name = "periodo_inicio2")
    private String PeriodoInicio2;

    @Column(name = "periodo_fin1")
    private String PeriodoFin1;

    @Column(name = "periodo_fin2")
    private String PeriodoFin2;

    @Column(name = "initial_street")
    private String InitialStreet;

    @Column(name = "final_street")
    private String FinalStreet;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "solicitud")
    private List<Carga> cargas = new ArrayList<>(); // Initialize as an empty ArrayList
}