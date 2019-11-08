package com.rest.consultorio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	@NotNull(message = "por favor informe o nome")
	private String nome;
	@NotNull(message = "por favor informe o rg")
	private String rg;
	@NotNull(message = "por favor informe o cpf")
	private String cpf;
	
	private String email;
	
	@NotNull(message = "por favor informe o endereço")
	@Embedded
	private Endereco endereco;	
	
	@JsonIgnoreProperties("paciente")
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	
	@JsonIgnoreProperties("paciente")
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Responsavel> responsaveis;
	
}