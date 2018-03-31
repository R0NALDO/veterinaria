package com.up.clinicavet.dao;

import java.sql.Date;

import com.up.clinicavet.model.Especie;

public class AnimalDAO extends Especie{
	private int 	id;
	private String 	nome;
	private Date 	nascimento;
	private Especie especie;
	
	public AnimalDAO(int id, String nome) { //construtor, tbm chama a classe espécie
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
