package virtualShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		PreparedStatement stm = 
				connection.prepareStatement("INSERT INTO product (name, description) VALUES ('Salém', 'a cat')", Statement.RETURN_GENERATED_KEYS);
		
		stm.execute();
		ResultSet result = stm.getGeneratedKeys();
		
		while(result.next()) {
			System.out.println("Created ID was: " + result.getInt(1));
		}
		
		connection.close();

	}

}
