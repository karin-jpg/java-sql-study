package br.com.karin.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.karin.jdbc.ConnectionFactory;
import br.com.karin.jdbc.dao.ProductDAO;

public class TestProductDAO {

	public static void main(String[] args) throws SQLException {

		Product product = new Product("Notebook", "A computer");

		try (Connection connection = new ConnectionFactory().getConnection()) {

			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.save(product);

			List<Product> products = productDAO.list();

			products.stream().forEach(p -> {
				System.out.println(p);
			});
		}
	}
}