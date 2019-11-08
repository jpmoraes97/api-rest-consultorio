package com.rest.consultorio.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "profissional")
public class Profissional implements Serializable {
	
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
	@NotNull(message = "por favor informe o telefone")
	private String telefone;
	@NotNull(message = "por favor informe o celular")
	private String celular;
	@NotNull(message = "por favor informe o endereço")
	@Embedded
	private Endereco endereco;
}