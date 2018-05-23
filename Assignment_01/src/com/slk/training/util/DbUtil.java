package com.slk.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
	private DbUtil() {
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("com.slk.training.resources.jdbc");
		String driver = rb.getString("driverClassName");
		String url = rb.getString("url");
		String user= rb.getString("user");
		String password = rb.getString("password");
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
}





