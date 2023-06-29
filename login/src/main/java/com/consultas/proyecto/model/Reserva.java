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

    private Long id_vuelo;
    private Long id_metodo_de_pago;
    private Long id_usuario;

    private Double precio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_MetodoDePago", nullable = false)
    private MetodoDePago metodoDePAgo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vuelo", nullable = false)
    private Vuelo vuelo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}