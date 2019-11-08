package com.rest.consultorio.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.consultorio.dto.TituloEstatisticaCategoria;
import com.rest.consultorio.dto.TituloEstatisticaDia;
import com.rest.consultorio.model.Titulo;
import com.rest.consultorio.projection.TituloResumo;
import com.rest.consultorio.repository.TituloRepository;
import com.rest.consultorio.repository.titulo.TituloFilter;
import com.rest.consultorio.service.TituloService;

@RestController
@RequestMapping("/titulos")
@CrossOrigin(origins = "*")
public class TituloResource {

	@Autowired
	private TituloService tituloService;
	@Autowired
	private TituloRepository tituloRepository;
	
	//@Autowired
	//private S3 s3;
	
	@GetMapping
	public Page<Titulo> listar(@RequestParam(value = "size", defaultValue = "7") int size,
							   @RequestParam(value = "page", defaultValue = "0") int page,
							   TituloFilter tituloFilter, Pageable pageable) {
		return tituloRepository.listar(tituloFilter, pageable);
	}
	
	@GetMapping(params = "resumo")
	public Page<TituloResumo> resumir(@RequestParam(value = "size", defaultValue = "7") int size,
							          @RequestParam(value = "page", defaultValue = "0") int page,
							          TituloFilter tituloFilter, Pageable pageable) {
		return tituloRepository.resumir(tituloFilter, pageable);
	}
	
	@GetMapping("/estatistica-categoria")
	public List<TituloEstatisticaCategoria> porCategoria(){
		return this.tituloRepository.porCategoria(LocalDate.now());
	}
	
	@GetMapping("/estatistica-dia")
	public List<TituloEstatisticaDia> porDia(){
		return this.tituloRepository.porDia(LocalDate.now());
	}
	
	@GetMapping("/relatorios/por-profissional")
	public ResponseEntity<byte[]> relatorioPorProfissional(
			@RequestParam @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate inicio,
			@RequestParam @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate fim) throws Exception{
		
		byte[] relatorio = tituloService.relatorioPorProfissional(inicio, fim);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	@GetMapping("/{id}")
	public Titulo buscar(@PathVariable Long id) {
		return tituloService.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Titulo salvar(@Valid @RequestBody Titulo titulo) {
		return tituloService.salvar(titulo);
	}
	
	@PutMapping("/{id}")
	public Titulo atualizar(@Valid @PathVariable Long id, @RequestBody Titulo titulo) {
		return tituloService.atualizar(id, titulo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
	    tituloService.deletar(id);
	}	
	
	@PostMapping("/anexo")
	public String uploadAnexo(@RequestParam MultipartFile anexo) throws IOException {
		
		//String nome = s3.salvarTemporariamente(anexo);
		//return nome;
		
		OutputStream output = new FileOutputStream(
		"/home/joao/"+"Área de Trabalho"+"/anexo--" + anexo.getOriginalFilename());
		output.write(anexo.getBytes());
		output.close(); 
		
		return "ok";
	}
	
	
}