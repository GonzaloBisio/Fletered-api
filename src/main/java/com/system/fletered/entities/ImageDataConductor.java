package com.system.fletered.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ImageDataConductor")
public class ImageDataConductor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_conductor")
    private Conductor idConductor;

    @Lob
    @Column(name = "imagedata")
    private byte[] imagedata;

}