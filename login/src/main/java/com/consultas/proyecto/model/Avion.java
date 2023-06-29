package com.consultas.proyecto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "avion")
@Getter
@Setter
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avion;

    private String codigo;
    private Long id_metodo_de_pago;
    private Long id_aerolinea;

    @OneToMany(mappedBy = "id_vuelo", cascade = CascadeType.ALL)
    private List<Vuelo> vuelo;

    @OneToMany(mappedBy = "id_asiento", cascade = CascadeType.ALL)
    private List<Asiento> asiento;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_aerolinea", nullable = false, insertable = false, updatable = false)
    private Aerolinea aerolinea;


}