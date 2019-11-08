package com.rest.consultorio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "titulo")
public class Titulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "por favor informe o tipo")
	private TipoDoTitulo tipo;
	@NotNull(message = "por favor informe a descrição")
	private String descricao;
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;
	@NotNull(message = "por favor informe a data de vencimento")
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@NotNull(message = "por favor informe o profissional")
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
	@NotNull(message = "por favor informe o valor")
	private BigDecimal valor;
	
	private String observacao;
}