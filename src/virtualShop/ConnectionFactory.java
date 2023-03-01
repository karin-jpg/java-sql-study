package virtualShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/virtual_shop?useTimezone=true&serverTimezon=UTC");
		comboPooledDataSource.setUser("virtual_shop_adm");
		comboPooledDataSource.setPassword("1234");
		
		this.dataSource = comboPooledDataSource;
	}

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/virtual_shop?useTimezone=true&serverTimezon=UTC",
				"virtual_shop_adm", "1234");

	}

}
