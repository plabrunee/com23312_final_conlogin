package com.consultas.proyecto.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aerolinea")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_aerolinea")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aerolinea;

    private String nombre;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "id_avion", cascade = CascadeType.ALL)
    private List<Avion> avion;




}
