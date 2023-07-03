package com.consultas.proyecto.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asiento")
@Data
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asiento;

    private String fila;
    private String columna;

    private Boolean esta_libre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_avion")
    private Avion avion;




}
