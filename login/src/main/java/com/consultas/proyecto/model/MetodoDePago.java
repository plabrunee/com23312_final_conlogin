package com.consultas.proyecto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "metodoDePago")
public class MetodoDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_MetodoDePago;

    private String nombre;
    private String descuento;

    @OneToMany(mappedBy = "metodoDePago", cascade = CascadeType.ALL)
    private List<Reserva> reserva;

}
