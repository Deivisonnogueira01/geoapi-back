package com.geobrapi.services;

import com.geobrapi.domain.dtos.EstadoDTO;

import java.util.List;

public interface EstadoService {

    List<EstadoDTO> getIdNomeEstados();
}
