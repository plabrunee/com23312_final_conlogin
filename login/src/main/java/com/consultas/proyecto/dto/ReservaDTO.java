package com.consultas.proyecto.dto;

import com.consultas.proyecto.enums.EMetodosDePago;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservaDTO {

    private List<AsientoDTO> asientos;

    private EMetodosDePago metodoDePago;

    private Long idVuelo;

}
