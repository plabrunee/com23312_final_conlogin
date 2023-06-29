package com.consultas.proyecto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aerolinea")
@Getter
@Setter
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aerolinea;

    private String nombre;


    @OneToMany(mappedBy = "id_avion", cascade = CascadeType.ALL)
    private List<Avion> avion;




}
