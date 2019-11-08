package com.rest.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.consultorio.model.Titulo;
import com.rest.consultorio.repository.titulo.TituloRepositoryQuery;

public interface TituloRepository extends JpaRepository<Titulo, Long> , TituloRepositoryQuery {

	Titulo findTituloById(Long id);
}
