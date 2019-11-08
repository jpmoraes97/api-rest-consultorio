package com.rest.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.consultorio.model.Agendamento;
import com.rest.consultorio.repository.agendamento.AgendamentoRepositoryQuery;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> , AgendamentoRepositoryQuery {

	Agendamento findAgendamentoById(Long id);
	
}
