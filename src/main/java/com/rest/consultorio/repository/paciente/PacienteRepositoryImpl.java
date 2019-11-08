package com.rest.consultorio.repository.paciente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.rest.consultorio.model.Paciente;

public class PacienteRepositoryImpl implements PacienteRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Paciente> filtrar(PacienteFilter pacienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Paciente> criteria = builder.createQuery(Paciente.class);
		Root<Paciente> root = criteria.from(Paciente.class);
		
		Predicate[] predicates = restricoes(pacienteFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Paciente> query = manager.createQuery(criteria);
		
		return query.getResultList();
		
	}
	
	private Predicate[] restricoes(PacienteFilter pacienteFilter, CriteriaBuilder builder,
			Root<Paciente> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(pacienteFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + pacienteFilter.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}