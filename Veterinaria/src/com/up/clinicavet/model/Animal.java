package com.up.clinicavet.model;

import java.sql.Date;
//a
public class Animal extends Especie{
	private int 	id;
	private String 	nome;
	private Date 	nascimento;
	private Especie especie;
	
	public Animal(int id, String nome) {
		super(id, nome);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
