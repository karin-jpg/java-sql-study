package virtualShop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestShowProducts {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		stm.execute("Select * from product");
		ResultSet result = stm.getResultSet();
		
		while(result.next()) {
			System.out.println("ID " + result.getInt("id") + " - Name: " + result.getString("name") + ", Description: " + result.getString("description"));
		}
		
		connection.close();
	}

}
