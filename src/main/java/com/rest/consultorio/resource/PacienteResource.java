package com.rest.consultorio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.rest.consultorio.model.Paciente;
import com.rest.consultorio.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteResource {

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PACIENTE')")
	public List<Paciente> listar() {
		return pacienteService.listar();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PACIENTE')")
	public Paciente buscar(@PathVariable Long id) {
		return pacienteService.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PACIENTE')")
	public Paciente salvar(@Valid @RequestBody Paciente paciente) {
		return pacienteService.salvar(paciente);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PACIENTE')")
	public Paciente atualizar(@Valid @PathVariable Long id, @RequestBody Paciente paciente) {
		return pacienteService.atualizar(id, paciente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PACIENTE')")
	public void deletar(@PathVariable Long id) {
		pacienteService.deletar(id);
	}
}
