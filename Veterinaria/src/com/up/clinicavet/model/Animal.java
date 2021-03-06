package com.up.clinicavet.model;

import java.sql.Date;

public class Animal{
	private int 	id;
	private String 	nome;
	private Date 	nascimento;
	private Especie especieId;
	
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Especie getEspecie() {
		return especieId;
	}
	public void setEspecie(Especie especie) {
		this.especieId = especie;
	}
}
