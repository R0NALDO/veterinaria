package com.up.clinicavet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		BuscaTodos(con, stm, rs);
		BuscaEspecies(con, stm, rs);
		BuscaNome(con, stm, rs);
		BuscaTipo(con, stm, rs);
		

	}

	private static void BuscaTodos(Connection con, PreparedStatement stm, ResultSet rs) {
		try {
			con = ConnectionFactory.getConnection();
			stm = con.prepareStatement(" select acronimo, nome, descricao from tipo_animal");
			rs = stm.executeQuery();
			while(rs.next()) {
			String acronimo = rs.getString(1);
			String nome = rs.getString(2);
			String descricao = rs.getString(3);
			System.out.println(acronimo + "\t" + nome + "\t" + descricao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(con != null) con.close();
				}catch(Exception e){
				e.printStackTrace();
				}
				try {
				if(stm!= null) stm.close();
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
				try {
				if(rs!= null) rs.close();
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
		}
	}
	
	private static void BuscaEspecies(Connection con, PreparedStatement stm, ResultSet rs) {
		try {
			con = ConnectionFactory.getConnection();
			stm = con.prepareStatement(" select nome, descricao, tipo_animal_acronimo from especie");
			rs = stm.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				String descricao = rs.getString(2);
				String tipAniAcronimo = rs.getString(3);
				System.out.println(nome + "\t" + descricao + "\t" + tipAniAcronimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(con != null) con.close();
				}catch(Exception e){
				e.printStackTrace();
				}
				try {
				if(stm!= null) stm.close();
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
				try {
				if(rs!= null) rs.close();
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
		}
	}
	
	private static void BuscaNome(Connection con, PreparedStatement stm, ResultSet rs) {
		Scanner ler = new Scanner(System.in);
		System.out.println("digite o nome a ser buscado");
		String entrada = ler.next();
		
		try {
			con = ConnectionFactory.getConnection();
			stm = con.prepareStatement(" select "+entrada+" from especie, animal, tipo_animal");
			rs = stm.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				System.out.println(nome + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try {
				if(stm!= null) stm.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(rs!= null) rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ler.close();
		}
	}
	
	private static void BuscaTipo(Connection con, PreparedStatement stm, ResultSet rs) {
		Scanner ler = new Scanner(System.in);
		System.out.println("digite o tipo de animal a ser buscado");
		String entrada = ler.next();
		
		try {
			con = ConnectionFactory.getConnection();
			stm = con.prepareStatement("SELECT TIPO_ANIMAL.NOME FROM TIPO_ANIMAL WHERE TIPO_ANIMAL.ACRONIMO = "+entrada);
			rs = stm.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				System.out.println(nome + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try {
				if(stm!= null) stm.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(rs!= null) rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ler.close();
		}
	}

	private static void teste1() {
		Animal a = new Animal(0, null);
		a.setNome("rex");
		a.setId(33);
		
		System.out.println(a.getNome());
		System.out.println(a.getId());
	}
}
