package com.rest.consultorio.repository.agendamento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rest.consultorio.model.Agendamento;
import com.rest.consultorio.projection.AgendamentoResumo;

public class AgendamentoRepositoryImpl implements AgendamentoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<AgendamentoResumo> resumir() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AgendamentoResumo> criteria = builder.createQuery(AgendamentoResumo.class);
		Root<Agendamento> root = criteria.from(Agendamento.class);
		
		criteria.select(builder.construct(AgendamentoResumo.class, 
				root.get("id"), root.get("data"), root.get("horario"),
				root.get("profissional").get("nome"), root.get("paciente").get("nome")));
		
		TypedQuery<AgendamentoResumo> typedQuery = manager.createQuery(criteria);
		
		return typedQuery.getResultList();
	}
}
