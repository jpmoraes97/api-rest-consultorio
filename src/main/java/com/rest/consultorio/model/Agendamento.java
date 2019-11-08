package com.rest.consultorio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "agendamento")
public class Agendamento implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	//@NotNull(message = "por favor informe a data")
	private LocalDate data;
	//@NotNull(message = "por favor informe o horário") 
	private LocalTime horario;
	//@NotNull(message = "por favor informe o paciente")
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	//@NotNull(message = "por favor informe o profissional")
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
}