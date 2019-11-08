package com.rest.consultorio.model;

public enum TipoDoTitulo {


	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private final String descricao;
	
	TipoDoTitulo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	
}
