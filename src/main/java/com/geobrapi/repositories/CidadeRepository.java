package com.geobrapi.repositories;

import com.geobrapi.domain.Cidade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<Cidade> findByIdCidade(Long idCidade);

    List<Cidade> findAll(@Nullable Specification<Cidade> spec, @NonNull Pageable pageable);

}
