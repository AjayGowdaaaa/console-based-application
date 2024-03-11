package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {

	public static Connection getConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/employee-management-system";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			System.out.println("Connection refused to database due to : " + e.getMessage());
		}
		return connection;
	}

	public static void closeConnections(Connection con, Statement stmt) {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnections(Connection con, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}