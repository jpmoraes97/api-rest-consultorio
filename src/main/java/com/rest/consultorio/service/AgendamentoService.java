package com.rest.consultorio.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.consultorio.model.Agendamento;
import com.rest.consultorio.repository.AgendamentoRepository;
import com.rest.consultorio.service.exceptions.NotPossibleException;
import com.rest.consultorio.service.exceptions.ResourceNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> listar() {
		return agendamentoRepository.findAll();
	}
	
	public Agendamento buscar(Long id) {
		Agendamento agendamento = agendamentoRepository.findAgendamentoById(id);
		if(agendamento == null) {
			throw new ResourceNotFoundException("Agendamento com ID : " +id+ " não foi localizado!");
		}
		return agendamento;
	}
	
	public Agendamento salvar(Agendamento agendamento) {
		validaAgendamentoDataHorarioProfissional(agendamento);
		return agendamentoRepository.save(agendamento);
	}
	
	public Agendamento atualizar(Long id, Agendamento agendamento) {
		Agendamento entity = agendamentoRepository.findAgendamentoById(id);
		if(entity == null) {
			throw new ResourceNotFoundException("Agendamento com ID : " +id+ " não foi localizado!");
		}
		BeanUtils.copyProperties(agendamento, entity, "id");
		agendamentoRepository.save(entity);
		return entity;
	}
	
	public void deletar(Long id) {
		Agendamento agendamento = agendamentoRepository.findAgendamentoById(id);
		if(agendamento == null) {
			throw new ResourceNotFoundException("Agendamento com ID : " +id+ " não foi localizado ou já foi deletado");
		}
		agendamentoRepository.delete(agendamento);
	}
	
	/*
	 * ESSE MÉTODO FAZ A VALIDAÇÃO IMPEDINDO QUE AGENDE PARA UMA MESMA DATA, HORARIO E PROFISSIONAL
	 * CASO O AGENDAMENTO FOR PARA OUTRO PROFISSIONAL, SERÁ POSSIVEL AGENDAR NA MESMA DATA E HORARIO
	 * TENDO EM VISTA QUE O ATENDIMENTO SERÁ EM OUTRA SALA!!!
	 */
	public void validaAgendamentoDataHorarioProfissional(Agendamento agendamento) {
		Iterable<Agendamento> todos = agendamentoRepository.findAll();
		for(Agendamento a : todos) {
			if(a.getData().equals(agendamento.getData()) 
					&& a.getHorario().equals(agendamento.getHorario())
					&& a.getProfissional().equals(agendamento.getProfissional())) {
				throw new NotPossibleException("Não é possível agendar nessa data e horário, pois já existe um agendamento para esse profissional!!");
			}
		}
	}
}