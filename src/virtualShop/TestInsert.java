package virtualShop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO product (name, description) VALUES ('Salém', 'gato travesso')", Statement.RETURN_GENERATED_KEYS);
		ResultSet result = stm.getGeneratedKeys();
		
		while(result.next()) {
			System.out.println("ID criado foi: " + result.getInt(1));
		}
		
		connection.close();

	}

}
