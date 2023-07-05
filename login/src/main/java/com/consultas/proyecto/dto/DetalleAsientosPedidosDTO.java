package com.consultas.proyecto.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class DetalleAsientosPedidosDTO {

    @JsonProperty("asiento")
    private AsientoDTO asientoDTO;
    private Long idVuelo;
    private Boolean fueAceptado;
    private String message;

    public DetalleAsientosPedidosDTO(AsientoDTO asientoDTO, Long idVuelo, Boolean fueAceptado, String message) {
        this.asientoDTO = asientoDTO;
        this.idVuelo = idVuelo;
        this.fueAceptado = fueAceptado;
        this.message = message;
    }



}
