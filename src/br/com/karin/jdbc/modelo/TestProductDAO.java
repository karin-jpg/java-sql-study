package br.com.karin.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.karin.jdbc.ConnectionFactory;
import br.com.karin.jdbc.dao.ProductDAO;

public class TestProductDAO {

	public static void main(String[] args) throws SQLException {

		Product product = new Product("Xbox", "A video game");

		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.save(product);
			
			List<Product> produtos = productDAO.list();
			
			produtos.stream().forEach(produto -> {
				System.out.println(produto);
			});

		}

	}
}
