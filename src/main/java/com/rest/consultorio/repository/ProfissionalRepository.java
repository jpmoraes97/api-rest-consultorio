package com.rest.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.consultorio.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

	Profissional findProfissionalById(Long id);
}
