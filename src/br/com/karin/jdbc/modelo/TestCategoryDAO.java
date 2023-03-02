package br.com.karin.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.karin.jdbc.ConnectionFactory;
import br.com.karin.jdbc.dao.CategoryDAO;

public class TestCategoryDAO {

	public static void main(String[] args) throws SQLException {
		
		Category category = new Category("Movies");

		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			categoryDAO.save(category);
			List<Category> categories = categoryDAO.list();
			
			categories.stream().forEach(c -> {
				System.out.println(c);
			});

		}


	}

}
