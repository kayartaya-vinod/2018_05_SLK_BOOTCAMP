package com.slk.training.programs;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.slk.training.entity.Contact;

public class P06_ObjectDeserializationDemo {
	public static void main(String[] args) throws Exception {
		String filename = "contacts.data";
		
		try(FileInputStream file = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(file);
				){
			Object obj = in.readObject();
			if(obj instanceof Contact) {
				Contact c = (Contact) obj;
				System.out.println("Name  = " + c.getFirstname() + " " + c.getLastname());
				System.out.println("Email = " + c.getEmail());
				System.out.println("Phone = " + c.getPhone());
				System.out.println("City  = " + c.getCity());
			}
		}
	}
}
