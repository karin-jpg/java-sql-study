package virtualShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM product where id > 2");
		
		stm.execute();
		System.out.println("O número de registros deletados foi de: " + stm.getUpdateCount());
	}

}
