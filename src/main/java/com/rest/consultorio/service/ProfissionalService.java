package com.rest.consultorio.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.consultorio.model.Profissional;
import com.rest.consultorio.repository.ProfissionalRepository;
import com.rest.consultorio.service.exceptions.ResourceNotFoundException;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public List<Profissional> listar() {
		return profissionalRepository.findAll();
	}
	
	public Profissional buscar(Long id) {
		Profissional profissional = profissionalRepository.findProfissionalById(id);
		if(profissional == null) {
			throw new ResourceNotFoundException("Profissional com ID : " +id+ " não foi localizado!");
		}
		return profissional;
	}
	
	public Profissional salvar(Profissional profissional) {
		return profissionalRepository.save(profissional);
	}
	
	public Profissional atualizar(Long id, Profissional profissional) {
		Profissional entity = profissionalRepository.findProfissionalById(id);
		if(entity == null) {
			throw new ResourceNotFoundException("Profissional com ID : " +id+ " não foi localizado!");
		}
		BeanUtils.copyProperties(profissional, entity, "id");
		profissionalRepository.save(entity);
		return entity;
	}
	
	public void deletar(Long id) {
		Profissional profissional = profissionalRepository.findProfissionalById(id);
		if(profissional == null) {
			throw new ResourceNotFoundException("Titulo com ID : " +id+ " não foi localizado ou já foi deletado!");
		}
		profissionalRepository.delete(profissional);
	}
}