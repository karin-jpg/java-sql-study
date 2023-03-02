package br.com.karin.jdbc;

import java.sql.SQLException;

public class TestConnectionPool {

	public static void main(String[] args) throws SQLException {
	
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.getConnection();
			System.out.println("Conexão " + (i+1));
		}
	}
}
