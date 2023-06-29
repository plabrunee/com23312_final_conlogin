package com.consultas.proyecto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asiento")
@Getter
@Setter
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asiento;

    private String fila;
    private String columna;

    private Boolean esta_libre;

    private Long id_avion;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_avion", nullable = false)
    private Avion avion;




}
