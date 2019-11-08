package com.rest.consultorio.repository.agendamento;

import java.util.List;

import com.rest.consultorio.projection.AgendamentoResumo;

public interface AgendamentoRepositoryQuery {

	List<AgendamentoResumo> resumir();
	
}
