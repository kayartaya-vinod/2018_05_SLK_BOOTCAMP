package com.slk.training.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.entity.Contact;
import com.slk.training.util.DateUtil;

public class ContactsDaoCsvImpl implements ContactsDao {

	private Map<Integer, Contact> map;
	private String header;
	
	public ContactsDaoCsvImpl() {
		map = new HashMap<>();
		try(FileReader file = new FileReader("contacts.csv");
				BufferedReader in = new BufferedReader(file)) {
			// skip the header
			header = in.readLine();
			String line;
			
			while((line=in.readLine())!=null) {
				Contact c = contactFromCsv(line);
				map.put(c.getId(), c);
			}
		}
		catch(Exception ex) {
		}
	}
	
	private void saveMapToCsv() {
		try(FileWriter file = new FileWriter("contacts.csv");
				PrintWriter out = new PrintWriter(file)) {
			
			if(header==null) {
				header = "id,first_name,last_name,email,gender,phone,dob,address,city,state,country,picture";
			}
			out.println(header);	
			
			for(Contact c: map.values()) {
				String csv = contactToCsv(c);
				out.println(csv);
			}
			
		}
		catch(Exception ex) {
		}
	}

	private String contactToCsv(Contact c) {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
				c.getId(),
				c.getFirstname(),
				c.getLastname(),
				c.getEmail(),
				c.getGender(),
				c.getPhone(),
				DateUtil.toString(c.getDob()),
				c.getAddress(),
				c.getCity(),
				c.getState(),
				c.getCountry(),
				c.getPicture());
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		// do some basic validation
		
		// add contact to the map
		map.put(contact.getId(), contact);
		saveMapToCsv();
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		if(map.containsKey(id)) {
			return map.get(id);
		}
		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {

	}

	@Override
	public void deleteContact(Integer id) throws DaoException {

	}

	@Override
	public List<Contact> getAll() throws DaoException {
		return new ArrayList<Contact>(map.values());
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		List<Contact> list = new ArrayList<>();
		
		for(Contact c: map.values()) {
			if(c.getCity().equals(city)) {
				list.add(c);
			}
		}
		return list;
	}
	private Contact contactFromCsv(String line) {
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
