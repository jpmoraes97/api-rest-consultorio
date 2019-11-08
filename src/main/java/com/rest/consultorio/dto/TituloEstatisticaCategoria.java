package com.rest.consultorio.dto;

import java.math.BigDecimal;

import com.rest.consultorio.model.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TituloEstatisticaCategoria {
	
	private Categoria categoria;
	
	private BigDecimal total;

}
