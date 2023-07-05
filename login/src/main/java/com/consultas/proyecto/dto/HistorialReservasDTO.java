package com.consultas.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialReservasDTO {


    private String nombre;

    private String apellido;

    private String mail;

    private String telefono;

    private List<VueloReservaDTO> vuelos;

}
