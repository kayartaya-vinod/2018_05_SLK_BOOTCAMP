package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P03_UsingPreparedStatement {

	public static void main(String[] args) throws Exception {
		
		String sql = "insert into phonebook(first_name, email, phone, dob) values(?,?,?,?)";
		
		try(
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
			
			while(true) {
				String fname = KeyboardUtil.getString("Enter firstname    : ");
				String email = KeyboardUtil.getString("Enter email address: ");
				String phone = KeyboardUtil.getString("Enter phone number : ");
				Date dob = KeyboardUtil.getDate("Enter date of birth (yyyy-mm-dd format): ");
				
				// convert java.util.Date to java.sql.Date because, the 
				// preparedStatement.setDate(..) takes java.sql.Date as the 
				// 2nd parameter
				java.sql.Date dt = new java.sql.Date(dob.getTime());
				
				stmt.setString(1, fname);
				stmt.setString(2, email);
				stmt.setString(3, phone);
				stmt.setDate(4, dt);
				
				stmt.executeUpdate();
				
				String ans = KeyboardUtil.getString("Wish to add another? yes/no: ");
				if(ans.equals("no")) {
					break;
				}
			}
		}
		System.out.println("Done.");
	}
}




