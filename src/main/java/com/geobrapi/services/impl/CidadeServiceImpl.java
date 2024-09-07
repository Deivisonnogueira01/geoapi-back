package com.geobrapi.services.impl;

import com.geobrapi.domain.Cidade;
import com.geobrapi.repositories.CidadeRepository;
import com.geobrapi.services.CidadeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class CidadeServiceImpl implements CidadeService {

    private CidadeRepository repository;

    @Override
    public Optional<Cidade> consultarCidadePorId(Long id) {
        return repository.findByIdCidade(id);
    }

    @Override
    public List<Cidade> buscar(Specification<Cidade> spec) {

        return repository.findAll(spec, PageRequest.of(0, 1000));
    }
}
