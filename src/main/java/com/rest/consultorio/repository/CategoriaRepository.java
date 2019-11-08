package com.rest.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.consultorio.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findCategoriaById(Long id);
}

