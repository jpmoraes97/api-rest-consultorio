package com.rest.consultorio.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.consultorio.model.Paciente;
import com.rest.consultorio.repository.PacienteRepository;
import com.rest.consultorio.service.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List<Paciente> listar() {
		return pacienteRepository.findAll();
	}
	
	public Paciente buscar(Long id) {
		Paciente paciente = pacienteRepository.findPacienteById(id);
		if(paciente == null) {
			throw new ResourceNotFoundException("Paciente com ID : " +id+ " não foi localizado!");
		}
		return paciente;
	}
	
	public Paciente salvar(Paciente paciente) {
		paciente.getResponsaveis().stream().forEach(r -> r.setPaciente(paciente));
		paciente.getTelefones().stream().forEach(t -> t.setPaciente(paciente));
		return pacienteRepository.save(paciente);
	}
	
	public Paciente atualizar(Long id, Paciente paciente) {
		Paciente entity = pacienteRepository.findPacienteById(id);
		if(entity == null) {
			throw new ResourceNotFoundException("Paciente com ID : " +id+ " não foi localizado!");
		}
		BeanUtils.copyProperties(paciente, entity, "id");
		pacienteRepository.save(entity);
		return entity;
	}
	
	public void deletar(Long id) {
		Paciente paciente = pacienteRepository.findPacienteById(id);
		if(paciente == null) {
			throw new ResourceNotFoundException("Titulo com ID : " +id+ " não foi localizado ou já foi deletado!");
		}
		pacienteRepository.delete(paciente);
	}
}