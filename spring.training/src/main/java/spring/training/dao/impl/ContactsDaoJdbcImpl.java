package spring.training.dao.impl;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;

public class ContactsDaoJdbcImpl implements ContactsDao {

	public ContactsDaoJdbcImpl() {
		System.out.println("ContactsDaoJdbcImpl instantiated!");
	}
	
	public int count() throws DaoException {
		return 100;
	}

}
