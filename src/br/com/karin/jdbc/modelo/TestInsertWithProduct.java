package br.com.karin.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.karin.jdbc.ConnectionFactory;

public class TestInsertWithProduct {

	public static void main(String[] args) throws SQLException {

		Product product = new Product("Xbox", "A video game");

		try (Connection connection = new ConnectionFactory().getConnection()) {
			connection.setAutoCommit(false);
			
			new PersistenceProduct(connection).saveProduct(product);
			
			System.out.println(product);

		}

	}
}
