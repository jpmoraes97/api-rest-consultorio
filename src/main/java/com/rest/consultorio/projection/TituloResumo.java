package com.rest.consultorio.projection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.rest.consultorio.model.TipoDoTitulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TituloResumo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private TipoDoTitulo tipo;
	private String descricao;
	private LocalDate dataPagamento;
	private LocalDate dataVencimento;
	private String categoria;
	private String profissional;
	private BigDecimal valor;
}
