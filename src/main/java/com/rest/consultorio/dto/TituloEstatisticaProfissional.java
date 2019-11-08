package com.rest.consultorio.dto;

import java.math.BigDecimal;

import com.rest.consultorio.model.Profissional;
import com.rest.consultorio.model.TipoDoTitulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TituloEstatisticaProfissional {
	
	private TipoDoTitulo tipo;
	
	private Profissional profissional;
	
	private BigDecimal total;

}
