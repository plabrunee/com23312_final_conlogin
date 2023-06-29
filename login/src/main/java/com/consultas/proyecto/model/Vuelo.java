package com.consultas.proyecto.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vuelo")
@Data

public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vuelo;

    private Date fecha_de_partida;
    private Date fecha_de_llegada;

    private String origen;
    private String destino;

    private Boolean tiene_conexion;

    private Long id_avion;

    @OneToMany(mappedBy = "id_vuelo", cascade = CascadeType.ALL)
    private List<Reserva> reserva;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_avion", nullable = false, updatable = false, insertable = false)
    private Avion avion;


}