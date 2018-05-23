package com.slk.training.programs;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.slk.training.entity.Contact;
import com.slk.training.util.DateUtil;

public class P05_ObjectSerializationDemo {

	public static void main(String[] args) throws Exception {
		String filename = "contacts.data";
		
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
		
		try( FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file)
				) {
			
			out.writeObject(c); 
			
		}
		
		System.out.println("Done!");
	}
}












