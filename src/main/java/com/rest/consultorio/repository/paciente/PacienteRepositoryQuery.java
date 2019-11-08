package com.rest.consultorio.repository.paciente;

import java.util.List;

import com.rest.consultorio.model.Paciente;

public interface PacienteRepositoryQuery {

	List<Paciente> filtrar(PacienteFilter pacienteFilter);
	
}
