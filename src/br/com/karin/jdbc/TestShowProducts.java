package br.com.karin.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestShowProducts {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.getConnection()) {

			try (PreparedStatement stm = connection.prepareStatement("Select * from product")) {
				stm.execute();
				ResultSet result = stm.getResultSet();

				while (result.next()) {
					System.out.println("ID " + result.getInt("id") + " - Name: " + result.getString("name")
							+ ", Description: " + result.getString("description"));
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				connection.rollback();
			}
		}

	}

}
