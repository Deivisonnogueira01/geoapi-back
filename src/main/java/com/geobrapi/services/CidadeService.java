package com.geobrapi.services;

import com.geobrapi.domain.Cidade;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CidadeService {

    Optional<Cidade> consultarCidadePorId(Long id);

    List<Cidade> buscar(Specification<Cidade> spec);

}
















