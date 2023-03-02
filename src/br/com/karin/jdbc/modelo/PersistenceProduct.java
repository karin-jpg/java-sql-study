package br.com.karin.jdbc.modelo;

import java.sql.Connection;

public class PersistencyProduct {

	private Connection connection;
	
	public PersistencyProduct(Connection connection) {
		this.connection = connection;
	}
	
	public void saveProduct(Product product) {
		
	}
}
