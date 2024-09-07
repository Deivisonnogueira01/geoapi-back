package com.geobrapi.services.impl;

import com.geobrapi.domain.Estado;
import com.geobrapi.domain.dtos.EstadoDTO;
import com.geobrapi.repositories.EstadoRepository;
import com.geobrapi.services.EstadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository repository;

    public EstadoServiceImpl(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoDTO> getIdNomeEstados() {
        List<Estado> estados = repository.findAll();

        List<EstadoDTO> estadosDTO = estados.stream()
                .map(estado -> new EstadoDTO(estado.getIdEstado(), estado.getNome(), estado.getAcronimo(), estado.getRegiao()))
                .collect(Collectors.toList());

        return estadosDTO;
    }
}
