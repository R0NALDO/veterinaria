package com.up.clinicavet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	public static void main(String[] args) {
		Connection conexao = null;
		PreparedStatement statement = null;
		try {
			conexao = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/clinicaveterinariadb", "SA", ""); //C:\\Users\\Ronaldo\\git\\veterinaria\\Veterinaria\\util
			statement = conexao.prepareStatement("delete from especie where id=999");
			int linhasRemovidas = statement.executeUpdate();
			System.out.println("Removidas: " + linhasRemovidas);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Conectado");
		// conexao.close(); .php?id= 
	}
}
