package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "palet")
public class Palet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "palet", cascade = CascadeType.ALL)
    private List<Object> objects;

    @ManyToOne
    @JoinColumn(name = "carga_id")
    private Carga carga;

    @Column(name = "peso")
    private Double peso;

}