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

import com.rest.consultorio.model.Profissional;
import com.rest.consultorio.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService profissionalService;
	
	@GetMapping
	public List<Profissional> listar() {
		return profissionalService.listar();
	}
	
	@GetMapping("/{id}")
	public Profissional buscar(@PathVariable Long id) {
		return profissionalService.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Profissional salvar(@Valid @RequestBody Profissional profissional) {
		return profissionalService.salvar(profissional);
	}
	
	@PutMapping("/{id}")
	public Profissional atualizar(@Valid @PathVariable Long id, @RequestBody Profissional profissional) {
		return profissionalService.atualizar(id, profissional);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		profissionalService.deletar(id);
	}
}