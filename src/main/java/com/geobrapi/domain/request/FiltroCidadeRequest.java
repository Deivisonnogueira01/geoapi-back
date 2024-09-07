package com.geobrapi.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FiltroCidadeRequest {

    private Integer idEstado;
    private Long id;
    private String nome;
}
