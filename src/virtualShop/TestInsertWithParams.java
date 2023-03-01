package virtualShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertWithParams {

	public static void main(String[] args) throws SQLException {
		
		String name = "Mouse'", description = "salve";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		PreparedStatement stm = 
				connection.prepareStatement("INSERT INTO product (name, description) VALUES (? , ? )", Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, name);
		stm.setString(2, description);
		
		stm.execute();
		
		ResultSet result = stm.getGeneratedKeys();
		
		while(result.next()) {
			System.out.println("ID criado foi: " + result.getInt(1));
		}
		
		connection.close();


	}

}
