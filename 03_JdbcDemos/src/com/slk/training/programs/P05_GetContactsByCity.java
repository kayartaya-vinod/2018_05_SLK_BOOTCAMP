package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P05_GetContactsByCity {

	public static void main(String[] args) throws Exception {
		
		String city = KeyboardUtil.getString("Enter city: ");
		String sql = "select * from phonebook where city = ?";
		
		try(Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
				
				stmt.setString(1, city);
				
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						System.out.println("Firstname = " + rs.getString("first_name"));
						System.out.println("Lastname = " + rs.getString("last_name"));
						System.out.println("Email = " + rs.getString("email"));
						System.out.println("Phone # = " + rs.getString("phone"));
						System.out.println("City = " + rs.getString("city"));
						System.out.println("------------------------------------");
					}
				}
			}
	}
}
