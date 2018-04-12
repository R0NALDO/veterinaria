package com.up.clinicavet.model;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.up.clinicavet.controller.ViewPrincipalController;
import com.up.clinicavet.factory.ConnectionFactory;
import com.up.clinicavet.interfac.IGenericDAO;
import com.up.clinicavet.view.ViewPrincipal;

public class Main {
	public static void main(String[] args) {
 		
		ViewPrincipal view = new ViewPrincipal();
		ViewPrincipalController controller = new ViewPrincipalController(view);
		view.setVisible(true);
		
		//		IGenericDAO< Animal, Long> ClienteDAO = new AnimalDAO(id, nome) ; 
//		Connection con = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//		BuscaTodos(con, stmt, rs);
//		BuscaEspecies(con, stmt, rs);
//		BuscaNome(con, stmt, rs);
//		BuscaTipo(con, stmt, rs);

	}

	private static void BuscaTodos(Connection con, PreparedStatement stmt, ResultSet rs) {
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.prepareStatement(" select acronimo, nome, descricao from tipo_animal");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String acronimo = 	rs.getString(1);
				String nome = 		rs.getString(2);
				String descricao = 	rs.getString(3);
				System.out.println(acronimo + "\t " + nome + "\t" + descricao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(con != null) con.close();
				}catch(Exception erro){
					erro.printStackTrace();
				}
				try {
				if(stmt!= null) stmt.close();
				} catch (SQLException erro) {
					erro.printStackTrace();
				}
				try {
				if(rs!= null) rs.close();
				} catch (SQLException erro) {
					erro.printStackTrace();
				}
		}
	}
	
	private static void BuscaEspecies(Connection con, PreparedStatement stmt, ResultSet rs) {
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.prepareStatement(" select nome, descricao, tipo_animal_acronimo from especie");
			rs = stmt.executeQuery();
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
				if(stmt!= null) stmt.close();
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
	
	private static void BuscaNome(Connection con, PreparedStatement stmt, ResultSet rs) {
		Scanner ler = new Scanner(System.in);
		System.out.println("digite o nome a ser buscado");
		String entrada = ler.next();
		
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.prepareStatement(" select "+entrada+" from especie, animal, tipo_animal");
			rs = stmt.executeQuery();
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
				if(stmt!= null) stmt.close();
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
	
	private static void BuscaTipo(Connection con, PreparedStatement stmt, ResultSet rs) {
		Scanner ler = new Scanner(System.in);
		System.out.println("digite o tipo de animal a ser buscado");
		String entrada = ler.next().toUpperCase();
		
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.prepareStatement("SELECT TIPO_ANIMAL.NOME FROM TIPO_ANIMAL WHERE UPPER(TIPO_ANIMAL.ACRONIMO) = UPPER("+entrada+")");//select a.id, a.nome, a.nascimento form animal a inner join especie e on (a.especi_id = e.id)  Where tipoanimalacronimo = 'GAT'
			rs = stmt.executeQuery();
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
				if(stmt!= null) stmt.close();
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
	private static void BuscaReturnGeneratedKeys(Connection con, PreparedStatement stmt, ResultSet rs) {
		Scanner ler = new Scanner(System.in);
		System.out.println("digite o tipo de animal a ser buscado");
		String entrada = ler.next().toUpperCase();
		
		
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.prepareStatement("SELECT TIPO_ANIMAL.NOME FROM TIPO_ANIMAL WHERE UPPER(TIPO_ANIMAL.ACRONIMO) = UPPER("+entrada+")", Statement.RETURN_GENERATED_KEYS);//select a.id, a.nome, a.nascimento form animal a inner join especie e on (a.especi_id = e.id)  Where tipoanimalacronimo = 'GAT'
			stmt.setString(1, "MeuCachorro3");
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));
			stmt.setLong(3, 6L);
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) { // pega o id gerado durante a gravação na base
				Long idGerado = rs.getLong(1);
			}else {
				throw new RuntimeException("erro ao buscar o id");
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
				if(stmt!= null) stmt.close();
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
		Animal a = new Animal();
		a.setNome("rex");
		a.setId(33);
		
		System.out.println(a.getNome());
		System.out.println(a.getId());
	}
}
 