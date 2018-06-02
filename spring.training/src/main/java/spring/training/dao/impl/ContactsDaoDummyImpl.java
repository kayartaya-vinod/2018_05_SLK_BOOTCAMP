package spring.training.dao.impl;

import java.util.List;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;
import spring.training.entity.Contact;

public class ContactsDaoDummyImpl implements ContactsDao {

	public ContactsDaoDummyImpl() {
		System.out.println("ContactsDaoDummyImpl instantiated!");
	}

	public int count() throws DaoException {
		return 0;
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public void deleteContact(Integer id) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

}
