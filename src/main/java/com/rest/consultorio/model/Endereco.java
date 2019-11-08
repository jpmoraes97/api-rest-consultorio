package com.rest.consultorio.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter	
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
}