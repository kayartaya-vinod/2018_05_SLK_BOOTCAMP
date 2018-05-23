package com.slk.training.programs;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.impl.ContactsDaoArrayListImpl;
import com.slk.training.entity.Contact;

public class P01_TestAddContact {

	public static void main(String[] args) throws DaoException {
		
		ContactsDao dao;
		dao = new ContactsDaoArrayListImpl(); // tight coupling
		
		Contact c1 = new Contact();
		c1.setId(1);
		c1.setFirstname("Vinod");
		c1.setEmail("vinod@vinod.co");
		c1.setPhone("9731424784");
		
		dao.addContact(c1);
		
		c1 = new Contact();
		c1.setId(2);
		c1.setFirstname("Shyam");
		c1.setEmail("shyam@exmaple.com");
		c1.setPhone("973144444");
		
		dao.addContact(c1);
		
		
		for(Contact c: dao.getAll()) {
			System.out.println(c);
		}
		
	}
}












