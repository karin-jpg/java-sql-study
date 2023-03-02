package br.com.karin.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection connection = connectionFactory.getConnection()) {
			System.out.println("Fechando conexão");
		}
	}

}