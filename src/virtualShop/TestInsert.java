package virtualShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.getConnection()) {

			connection.setAutoCommit(false);
			
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO product (name, description) VALUES ('Salém', 'a cat')",
					Statement.RETURN_GENERATED_KEYS)) {

				stm.execute();
				connection.commit();
				ResultSet result = stm.getGeneratedKeys();

				while (result.next()) {
					System.out.println("Created ID was: " + result.getInt(1));
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				connection.rollback();
			}
		}

	}

}
