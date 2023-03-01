package virtualShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.getConnection()) {
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement("DELETE FROM product where id > 2")) {

				stm.execute();
				connection.commit();
				System.out.println("O número de registros deletados foi de: " + stm.getUpdateCount());
				
			} catch (Exception exception) {
				exception.printStackTrace();
				connection.rollback();
			}
		}
	}

}
