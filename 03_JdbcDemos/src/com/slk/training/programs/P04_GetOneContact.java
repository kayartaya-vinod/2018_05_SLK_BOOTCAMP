package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P04_GetOneContact {

	public static void main(String[] args) throws Exception {
		int id = KeyboardUtil.getInt("Enter id: ");
		String sql = "select * from phonebook where id = ?";
		
		try(Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, id);
			
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					System.out.println("Firstname = " + rs.getString("first_name"));
					System.out.println("Lastname = " + rs.getString("last_name"));
					System.out.println("Email = " + rs.getString("email"));
					System.out.println("Phone # = " + rs.getString("phone"));
					
				}
				else {
					System.out.println("No data found for id " + id);
				}
			}
		}
	}
}








