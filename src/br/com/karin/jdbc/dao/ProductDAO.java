package br.com.karin.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.karin.jdbc.modelo.Product;

public class ProductDAO {

	private Connection connection;

	public ProductDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Product product) throws SQLException {

		String sql = "INSERT INTO products (name, description) VALUES (?, ?)";

		connection.setAutoCommit(false);

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

	public List<Product> list() throws SQLException {
		List<Product> produtos = new ArrayList<Product>();

		String sql = "SELECT * FROM products";

		try (PreparedStatement stm = connection.prepareStatement(sql)) {

			stm.execute();

			try (ResultSet result = stm.getResultSet()) {
				while (result.next()) {
					Product product = new Product(result.getInt("id"), result.getString("name"),
							result.getString("description"));

					produtos.add(product);
				}
			}
		}
		return produtos;

	}
}
