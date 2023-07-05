package com.consultas.proyecto.dto;


import com.consultas.proyecto.model.Asiento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsientoVueloDTO {


    private Asiento asiento;

    @Column(name = "esta_libre", nullable = false)
    private Boolean estaLibre;

    @Column(name = "precio")
    private Double precio;
}
