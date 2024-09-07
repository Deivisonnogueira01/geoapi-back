package com.geobrapi.specifications;

import com.geobrapi.domain.Cidade;
import com.geobrapi.domain.request.FiltroCidadeRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class CidadeSpec {


    private CidadeSpec() {
    }

    public static Specification<Cidade> filterBy(FiltroCidadeRequest filtro) {
        return Specification.where(
                comEstado(filtro.getIdEstado()))
                .and(comNome(filtro.getNome()))
                .and(comCodigoIbge(filtro.getId()));
    }

    private static Specification<Cidade> comEstado(Integer idEstado) {
        return (root, query, cb) -> Objects.isNull(idEstado) ? cb.conjunction() : cb.equal(root.get("idEstado"), idEstado);
    }

    private static Specification<Cidade> comCodigoIbge(Long codigoIbge) {
        return (root, query, cb) -> Objects.isNull(codigoIbge) ? cb.conjunction() : cb.equal(root.get("idCidade"), codigoIbge);
    }

    private static Specification<Cidade> comNome(String nome) {
        return (root, query, cb) -> Objects.isNull(nome) ? cb.conjunction() : cb.like(root.get("nome"), "%" + nome + "%");
    }

}
