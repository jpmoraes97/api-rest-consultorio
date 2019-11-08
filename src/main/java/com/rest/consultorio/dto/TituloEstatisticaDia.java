package com.rest.consultorio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.rest.consultorio.model.TipoDoTitulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TituloEstatisticaDia {
	
	private TipoDoTitulo tipo;
	
	private LocalDate dia;
	
	private BigDecimal total;

}
