package br.com.karin.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {

	private Connection connection;
	
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void saveProduct(Product product) throws SQLException {
		
		String sql = "INSERT INTO product (name, description) VALUES (?, ?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, product.getName());
			stm.setString(2, product.getDescription());

			stm.execute();
			connection.commit();

			try (ResultSet result = stm.getGeneratedKeys()) {
				while (result.next()) {
					product.setId(result.getInt(1));
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			connection.rollback();
		}

	}
}
