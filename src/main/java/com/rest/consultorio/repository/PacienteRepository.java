package com.rest.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.consultorio.model.Paciente;
import com.rest.consultorio.repository.paciente.PacienteRepositoryQuery;

public interface PacienteRepository extends JpaRepository<Paciente, Long> , PacienteRepositoryQuery {

	Paciente findPacienteById(Long id);
	
}
