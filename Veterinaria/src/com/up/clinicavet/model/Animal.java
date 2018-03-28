package com.up.clinicavet.model;

import java.sql.Date;

public class Animal extends Especie{
	private int 	id;
	private String 	nome;
	private Date 	nascimento;
	private Especie especie;
	
	public Animal(int id, String nome) { //construtor, tbm chama a classe espécie
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
}
