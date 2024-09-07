package com.geobrapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Estado {

    @Id
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nome")
    private String nome;

    @Column(name = "acronimo")
    private String acronimo;

    @Column(name = "regiao")
    private String regiao;

    @Column(name = "pos_estado")
    private String posEstado;

}

