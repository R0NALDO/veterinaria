package com.up.clinicavet.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.up.clinicavet.model.Animal;

public class ExibicaoAnimais extends AbstractTableModel{
	private static final int NUM_COLUNAS_ANIMAL = 3;
	private List<Animal> animaisTabela;
	
	public ExibicaoAnimais(){
	}
	
	public ExibicaoAnimais (List<Animal> animais){
		animaisTabela = animais;
	}
	
	public List<Animal> getAnimaisTabela(){
		return animaisTabela;
	}
	
	public void setAnimaisTabela(List<Animal> animaisTabela){
		
		this.animaisTabela = animaisTabela;
	}
	
	@Override
	public String getColumnName (int coluna){
		switch (coluna) {
		case 0:
			return "Identificador";
		case 1:
			return "Nome";
		case 2:
			return "Nascimento";

		default:
			throw new RuntimeException("solicitada uma coluna");
		}
		
	}
	
	@Override
	public int getColumnCount(){
		return NUM_COLUNAS_ANIMAL;
	}
	
	@Override
	
	public int getRowCount(){
		if (animaisTabela != null) {
			return animaisTabela.size();
		} else {
			return 0;

		}
	}
	
	@Override
	
	public Object  getValueAt(int linha, int coluna){
		switch (coluna) {
		case 0:
			return animaisTabela.get(linha).getId();
			
		case 1:
			return animaisTabela.get(linha).getNome();
			
		case 2:
			return animaisTabela.get(linha).getNascimento();

		default:
			return null;
		}
	}


}
