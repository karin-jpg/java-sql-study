package virtualShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() throws SQLException {
		
		return DriverManager
				.getConnection("jdbc:mysql://localhost/virtual_shop?useTimezone=true&serverTimezon=UTC", "virtual_shop_adm", "1234");
		
	}
	
	
	
}
