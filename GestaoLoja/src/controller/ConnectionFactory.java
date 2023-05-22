package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER  = "com.mysql.cj.jdbc.Driver";
	
	// User do banco
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "1234";
	
	//Caminho do banco de dados, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost/gestaoloja";
	
	/*
	 * Conexão com o banco de dados
	 */
	public static Connection getConnection() throws Exception{
		
		try {
		// Faz com que a classe seja carregada pela JVM e Cria conexão com o banco de dados
        Class.forName(DRIVER);
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		} catch (ClassNotFoundException | SQLException ex){
			
			throw new RuntimeException("Erro na conexão:", ex);
			
		}
	 }
	
	public static void closeConnection(Connection con) {
		
			try {
				if(con!=null){
				con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static void closeConnection(Connection con, PreparedStatement pst) {
		
		try {
			if(pst!=null){
			pst.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
		
		try {
			if(rs!=null){
			rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

