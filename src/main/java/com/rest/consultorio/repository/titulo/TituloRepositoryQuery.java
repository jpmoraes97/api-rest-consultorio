package com.rest.consultorio.repository.titulo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rest.consultorio.dto.TituloEstatisticaCategoria;
import com.rest.consultorio.dto.TituloEstatisticaDia;
import com.rest.consultorio.dto.TituloEstatisticaProfissional;
import com.rest.consultorio.model.Titulo;
import com.rest.consultorio.projection.TituloResumo;

public interface TituloRepositoryQuery {
	
	Page<TituloResumo> resumir(TituloFilter tituloFilter, Pageable pageable);
	
	Page<Titulo> listar(TituloFilter tituloFilter, Pageable pageable);
	
	List<TituloEstatisticaCategoria> porCategoria(LocalDate mesReferencia);
	
	List<TituloEstatisticaDia> porDia(LocalDate mesReferencia);
	
	List<TituloEstatisticaProfissional> porProfissional(LocalDate inicio, LocalDate fim);

}
