package spring.training.dao.impl;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;

public class ContactsDaoDummyImpl implements ContactsDao {
	
	public ContactsDaoDummyImpl() {
		System.out.println("ContactsDaoDummyImpl instantiated!");
	}

	public int count() throws DaoException {
		return 0;
	}

}
