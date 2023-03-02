package virtualShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertWithParams {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		//adding connections inside try params for them to close automatically
		try (Connection connection = connectionFactory.getConnection()) {

			connection.setAutoCommit(false);
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO product (name, description) VALUES (? , ? )", Statement.RETURN_GENERATED_KEYS)) {

				addVariable("Tv", "Big screen", stm);
				addVariable("Radio", "Makes noise", stm);
				addVariable("Controller", "For your big screen", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();

			}
		}
	}

	private static void addVariable(String name, String description, PreparedStatement stm) throws SQLException {
		stm.setString(1, name);
		stm.setString(2, description);

		stm.execute();

		if (name == "Radio") {
			throw new RuntimeException("Error on insert");
		}

		ResultSet result = stm.getGeneratedKeys();

		while (result.next()) {
			System.out.println("ID criado foi: " + result.getInt(1));
		}

		result.close();
	}

}
