package com.geobrapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cidade")
@Getter
@Setter
@ToString
public class Cidade {


	@Id
	@Column(name = "id_cidade")
	private Long idCidade;

	@Column(name = "id_estado")
	private Integer idEstado;

	@Column(name = "nome")
	private String nome;

	@Column(name = "codigo_tom")
	private String codigoTom;

}
