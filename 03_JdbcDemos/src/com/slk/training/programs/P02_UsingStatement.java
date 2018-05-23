package com.slk.training.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P02_UsingStatement {

	public static void main(String[] args) throws Exception {
		try(
				Connection conn = DbUtil.getConnection();
				Statement stmt = conn.createStatement();
				) {
			
			String fname = KeyboardUtil.getString("Enter firstname    : ");
			String email = KeyboardUtil.getString("Enter email address: ");
			String phone = KeyboardUtil.getString("Enter phone number : ");
			
			String sql = "insert into phonebook (first_name, email, phone) values('"
					+fname+"', '"+email+"', '"+phone+"')";
			
			// String sql = "insert into phonebook(first_name, email, phone) values(?,?,?)";;
			
			conn.setAutoCommit(false);
			try {
				stmt.executeUpdate(sql);
				conn.commit();
				System.out.println("Data inserted successfully!");
			} catch (Exception e) {
				conn.rollback();
				System.out.println("Could not insert data!");
			}
		}
	}
}









