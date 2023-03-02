package br.com.karin.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.karin.jdbc.modelo.Category;

public class CategoryDAO {

	private Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Category category) throws SQLException {

		String sql = "INSERT INTO categories (name) VALUES (?)";

		connection.setAutoCommit(false);

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, category.getName());

			stm.execute();
			connection.commit();

			try (ResultSet result = stm.getGeneratedKeys()) {
				while (result.next()) {
					category.setId(result.getInt(1));
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			connection.rollback();
		}

	}

	public List<Category> list() throws SQLException {

		List<Category> categories = new ArrayList<Category>();

		String sql = "SELECT * FROM categories";

		try (PreparedStatement stm = connection.prepareStatement(sql)) {

			stm.execute();

			try (ResultSet result = stm.getResultSet()) {
				while (result.next()) {
					Category category = new Category(result.getInt("id"), result.getString("name"));
					categories.add(category);
				}
			}
		}

		return categories;
	}
}
