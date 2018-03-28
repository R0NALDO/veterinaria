package com.up.clinicavet.model;

import java.util.List;

	public class Especie {
		
		private int 	id;
		private String 	nome;
		private List<Animal> animais;
	
	public Especie(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId(){
		return this.id;
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
	
	public List<Animal> getAnimais(){
		return animais;
	}
	
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public void adicionarAnimal(Animal a){
		this.animais.add(a);
	}

	
}