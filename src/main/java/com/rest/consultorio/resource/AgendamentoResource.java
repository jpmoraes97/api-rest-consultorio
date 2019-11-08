package com.rest.consultorio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.consultorio.model.Agendamento;
import com.rest.consultorio.projection.AgendamentoResumo;
import com.rest.consultorio.repository.AgendamentoRepository;
import com.rest.consultorio.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins="*")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	
	@GetMapping
	public List<Agendamento> listar() {
		return agendamentoService.listar();
	}
	
	
	@GetMapping(params = "resumo")
	public List<AgendamentoResumo> resumir() {
		return agendamentoRepository.resumir();
	}
	
	@GetMapping("/{id}")
	public Agendamento buscar(@PathVariable Long id) {
		return agendamentoService.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Agendamento salvar(@Valid @RequestBody Agendamento agendamento) {
		return agendamentoService.salvar(agendamento);
	}
	
	@PutMapping("/{id}")
	public Agendamento atualizar(@Valid @PathVariable Long id, @RequestBody Agendamento agendamento) {
		return agendamentoService.atualizar(id, agendamento);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		agendamentoService.deletar(id);
	}
}