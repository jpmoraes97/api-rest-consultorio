package com.rest.consultorio.repository.titulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.rest.consultorio.dto.TituloEstatisticaCategoria;
import com.rest.consultorio.dto.TituloEstatisticaDia;
import com.rest.consultorio.dto.TituloEstatisticaProfissional;
import com.rest.consultorio.model.Titulo;
import com.rest.consultorio.projection.TituloResumo;

public class TituloRepositoryImpl implements TituloRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Titulo> listar(TituloFilter tituloFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Titulo> criteria = builder.createQuery(Titulo.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		
		Predicate[] predicates = restricoes(tituloFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Titulo> typedQuery = manager.createQuery(criteria);
		paginacao(typedQuery, pageable);
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, total(tituloFilter));
		
	}

	@Override
	public Page<TituloResumo> resumir(TituloFilter tituloFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TituloResumo> criteria = builder.createQuery(TituloResumo.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		
		criteria.select(builder.construct(TituloResumo.class, 
				root.get("id"), root.get("tipo"), root.get("descricao"),
				root.get("dataPagamento"), root.get("dataVencimento"),
				root.get("categoria").get("nome"),
				root.get("profissional").get("nome"),
				root.get("valor")
				));
		
		//criteria.groupBy(root.get("dataVencimento"));
		
		Predicate[] predicates = restricoes(tituloFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<TituloResumo> typedQuery = manager.createQuery(criteria);
		paginacao(typedQuery, pageable);
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, total(tituloFilter));
	}
	
	private void paginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalPorPagina;
		
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalPorPagina);
	}
	
	private Predicate[] restricoes(TituloFilter tituloFilter, CriteriaBuilder builder, Root<Titulo> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(tituloFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")), 
					"%"+tituloFilter.getDescricao().toLowerCase()+"%"));
		}
		if(tituloFilter.getDataVencimentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataVencimento"), 
											tituloFilter.getDataVencimentoDe()));
		}
		if(tituloFilter.getDataVencimentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataVencimento"), 
											tituloFilter.getDataVencimentoAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	private Long total(TituloFilter tituloFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		
		Predicate[] predicates = restricoes(tituloFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();	
	}

	@Override
	public List<TituloEstatisticaCategoria> porCategoria(LocalDate mesReferencia) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TituloEstatisticaCategoria> criteria = builder.createQuery(TituloEstatisticaCategoria.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		
		criteria.select(builder.construct(TituloEstatisticaCategoria.class, 
				root.get("categoria"),
				builder.sum(root.get("valor"))));
		
		LocalDate primeiroDia = mesReferencia.withDayOfMonth(1);
		LocalDate ultimoDia = mesReferencia.withDayOfMonth(mesReferencia.lengthOfMonth());
		
		criteria.where(
				builder.greaterThanOrEqualTo(root.get("dataVencimento"), primeiroDia),
				builder.lessThanOrEqualTo(root.get("dataVencimento"), ultimoDia)
				);
		
		criteria.groupBy(root.get("categoria"));
		
		TypedQuery<TituloEstatisticaCategoria> typedQuery = manager.createQuery(criteria);
		
		return typedQuery.getResultList();	
		
	}

	@Override
	public List<TituloEstatisticaDia> porDia(LocalDate mesReferencia) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TituloEstatisticaDia> criteria = builder.createQuery(TituloEstatisticaDia.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		
		criteria.select(builder.construct(TituloEstatisticaDia.class, 
				root.get("tipo"), root.get("dataVencimento"),
				builder.sum(root.get("valor"))));
		
		LocalDate primeiroDia = mesReferencia.withDayOfMonth(1);
		LocalDate ultimoDia = mesReferencia.withDayOfMonth(mesReferencia.lengthOfMonth());
		
		criteria.where(
				builder.greaterThanOrEqualTo(root.get("dataVencimento"), primeiroDia),
				builder.lessThanOrEqualTo(root.get("dataVencimento"), ultimoDia)
				);
		
		criteria.groupBy(root.get("tipo"), root.get("dataVencimento"));
		
		TypedQuery<TituloEstatisticaDia> typedQuery = manager.createQuery(criteria);
		
		return typedQuery.getResultList();	
	}

	@Override
	public List<TituloEstatisticaProfissional> porProfissional(LocalDate inicio, LocalDate fim) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TituloEstatisticaProfissional> criteria = builder.createQuery(TituloEstatisticaProfissional.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		
		criteria.select(builder.construct(TituloEstatisticaProfissional.class,
				root.get("tipo"), root.get("profissional"), builder.sum(root.get("valor"))));
		
		criteria.where(
				builder.greaterThanOrEqualTo(root.get("dataVencimento"), inicio),
				builder.lessThanOrEqualTo(root.get("dataVencimento"), fim)
				);
		
		criteria.groupBy(root.get("tipo"), root.get("profissional"));
		
		TypedQuery<TituloEstatisticaProfissional> typedQuery = manager.createQuery(criteria);
		
		return typedQuery.getResultList();
	}
	
	
}