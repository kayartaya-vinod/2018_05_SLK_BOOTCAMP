package com.slk.training.dao;

import com.slk.training.dao.impl.ContactsDaoArrayListImpl;
import com.slk.training.dao.impl.ContactsDaoCsvImpl;
import com.slk.training.dao.impl.ContactsDaoJdbcImpl;
import com.slk.training.dao.impl.ContactsDaoSerializableImpl;

public final class DaoFactory {

	private DaoFactory() {
	}

	// default implementation of ContactsDao will be returned from here
	public static ContactsDao getContactsDao() throws DaoException {
		return new ContactsDaoCsvImpl();
	}

	// customized implementation of ContactsDao will be returned from here
	public static ContactsDao getContactsDao(String type) throws DaoException {
		switch (type.toLowerCase()) {
		case "arraylist":
			return new ContactsDaoArrayListImpl();
		case "serializable": 
			return new ContactsDaoSerializableImpl();
		case "csv":
			return new ContactsDaoCsvImpl();
		case "jdbc":
			return new ContactsDaoJdbcImpl();
		case "hashmap":
			throw new DaoException("Not implemented yet!");
		}
		throw new DaoException("Invalid value for 'type'");
	}
}
