package virtualShop;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		stm.execute("DELETE FROM product where id > 2", Statement.RETURN_GENERATED_KEYS);
		
		System.out.println("O número de registros deletados foi de: " + stm.getUpdateCount());
	}

}
