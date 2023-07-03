package com.consultas.proyecto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "avion")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_avion")

public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avion;

    private String codigo;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    private List<Vuelo> vuelo;


    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    private List<Asiento> asiento;


    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_aerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Override
    public String toString() {
        return "Avion{" +
                "id_avion=" + id_avion +
                ", codigo='" + codigo + '\'' +
                ", vuelo=" + vuelo +
                ", asiento=" + asiento +
                ", aerolinea=" + aerolinea +
                '}';
    }
}