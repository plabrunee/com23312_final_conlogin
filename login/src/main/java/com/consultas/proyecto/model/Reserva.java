package com.consultas.proyecto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reserva")
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    private Double precio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_MetodoDePago", nullable = false)
    private MetodoDePago metodoDePago;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vuelo", nullable = false, updatable = false, insertable = false)
    private Vuelo vuelo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}