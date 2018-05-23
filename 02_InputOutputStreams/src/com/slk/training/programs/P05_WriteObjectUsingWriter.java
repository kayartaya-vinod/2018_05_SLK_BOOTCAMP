package com.slk.training.programs;

import java.io.FileWriter;
import java.io.PrintWriter;

import com.slk.training.entity.Contact;
import com.slk.training.util.DateUtil;

public class P05_WriteObjectUsingWriter {

	public static void main(String[] args) throws Exception {
		
		String filename = "tbd.txt";
		Contact c = new Contact();
		c.setId(1);
		c.setFirstname("Vinod");
		c.setLastname("Kumar");
		c.setAddress("ISRO lyt");
		c.setCity("Bangalore");
		c.setState("Karnataka");
		c.setCountry("India");
		c.setEmail("vinod@vinod.co");
		c.setPhone("9731424784");
		c.setDob(DateUtil.toDate("1974-01-20"));
		c.setGender("Male");
		
		try(FileWriter file = new FileWriter(filename, true);
				PrintWriter out = new PrintWriter(file)){
			out.println(c);
		}
		
		System.out.println("Done!");
		
	}
}
