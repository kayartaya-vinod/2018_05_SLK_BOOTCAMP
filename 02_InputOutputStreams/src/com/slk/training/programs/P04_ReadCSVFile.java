package com.slk.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;

import com.slk.training.entity.Contact;
import com.slk.training.util.DateUtil;

public class P04_ReadCSVFile {

	public static void main(String[] args) throws Exception {
		String filename = "contacts.csv";
		try (FileReader file = new FileReader(filename); 
				BufferedReader in = new BufferedReader(file);) {

			// skip the first line, as it contains column headers
			in.readLine();

			String line;
			while ((line = in.readLine()) != null) {
				Contact c = contactFromCsv(line);
				System.out.println(c);
			}
		}
	}

	private static Contact contactFromCsv(String line) {
		Contact c = new Contact();
		// id,first_name,last_name,email,gender,phone,dob,address,city,state,country
		String[] data = line.split(",");
		c.setId(new Integer(data[0]));
		c.setFirstname(data[1]);
		c.setLastname(data[2]);
		c.setEmail(data[3]);
		c.setGender(data[4]);
		c.setPhone(data[5]);
		
		c.setDob(DateUtil.toDate(data[6]));
		
		c.setAddress(data[7]);
		c.setCity(data[8]);
		c.setState(data[9]);
		c.setCountry(data[10]);
		
		return c;
	}

}








