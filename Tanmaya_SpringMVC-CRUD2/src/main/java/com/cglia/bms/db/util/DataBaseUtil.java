package com.cglia.bms.db.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataBaseUtil {
	private static BasicDataSource dataSource;

	static {

		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/database_name");
		dataSource.setUsername("user_name");
		dataSource.setPassword("password");
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		if(connection!=null && !connection.isClosed()) {
			System.out.println("connection is established");
		}else {
			System.out.println("connection failed to establish");
		}
		return connection;
	}
}
