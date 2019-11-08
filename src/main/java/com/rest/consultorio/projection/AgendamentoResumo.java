package com.rest.consultorio.projection;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgendamentoResumo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate data;
	private LocalTime horario;
	private String profissional;
	private String paciente;	
}