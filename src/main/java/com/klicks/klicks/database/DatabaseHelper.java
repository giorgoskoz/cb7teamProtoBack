package com.klicks.klicks.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseHelper {
	
	public DatabaseHelper() {
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "konnos1987");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cb7team-proto?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8&autoReconnect=true",
					connectionProps);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static int getSimpleUsersCount() {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE fk_role_id = 1");) {
			int count = 0;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			return count;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
