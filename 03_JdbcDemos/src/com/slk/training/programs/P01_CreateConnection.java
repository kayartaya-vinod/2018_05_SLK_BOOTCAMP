package com.slk.training.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class P01_CreateConnection {

	public static void main(String[] args) throws Exception {
		
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/slk_java";
		String username = "root";
		String password = "root";
		
		// 1. Load the JDBC type 4 driver class for MySQL
		// by loading the Driver class to the JVM, the driver class itself
		// registers an instance of the same class with DriverManager
		Class.forName(driverClassName);
		
		try(Connection conn = DriverManager.getConnection(url, username, password);) {
			System.out.println("got a connection of type: " + conn.getClass());
		}
		
	}
}
